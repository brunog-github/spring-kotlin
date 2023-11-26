package dev.bruno.springkotlin.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity(name = "_users")
data class User(
    @Id
    val id: String = UUID.randomUUID().toString().replace("-",""),
    val name: String,
    val age: Int
)