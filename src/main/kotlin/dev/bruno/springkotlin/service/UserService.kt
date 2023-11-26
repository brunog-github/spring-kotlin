package dev.bruno.springkotlin.service

import dev.bruno.springkotlin.domain.model.User
import dev.bruno.springkotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun getAllUsers(): List<User> = userRepository.findAll()

    fun addNewUser(user: User) = userRepository.save(user)

    fun findUserById(id: String) = userRepository.findByIdOrNull(id)

    fun deleteUser(id: String) = userRepository.deleteById(id)
}