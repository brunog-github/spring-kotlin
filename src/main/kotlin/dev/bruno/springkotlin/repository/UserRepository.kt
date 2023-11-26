package dev.bruno.springkotlin.repository

import dev.bruno.springkotlin.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, String>