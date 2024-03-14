package ru.altmanea.webapp.data

import kotlinx.serialization.Serializable

@Serializable
class Student(
    val firstname: String,
    val surname: String,
    val group: String
){
    fun fullname() =
        "$firstname $surname"
}

@Serializable
class Group(
    val name: String
)