package dev.bruno.springkotlin.controller

import dev.bruno.springkotlin.domain.model.User
import dev.bruno.springkotlin.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.getAllUsers()
        return ResponseEntity.status(HttpStatus.FOUND).body(users)
    }

    @PostMapping("/user")
    fun addNewUser(@RequestBody user: User): ResponseEntity<String> {
        userService.addNewUser(user)
        return ResponseEntity.status(HttpStatus.CREATED).body("user created")
    }

    @GetMapping("/user/{id}")
    fun findUserById(@PathVariable("id") id: String): ResponseEntity<User?> {
        val user = userService.findUserById(id)
        return if (user != null) {
            ResponseEntity.accepted().body(user)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(null)
        }
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id", required = true) id: String): ResponseEntity<String> {
        userService.deleteUser(id)
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("user deleted")
    }
}