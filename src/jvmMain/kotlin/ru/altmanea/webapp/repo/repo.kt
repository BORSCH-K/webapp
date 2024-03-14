package ru.altmanea.webapp.repo

import ru.altmanea.webapp.data.Group
import ru.altmanea.webapp.data.Student

val students: MutableList<Student> = mutableListOf(
    Student("Sheldon", "Cooper", "21m"),
    Student("Leonard", "Hofstadter", "21z"),
    Student("Howard", "Wolowitz", "21m"),
    Student("Penny", "Hofstadter", "21k")
)

//val groups: Set<String> = students.map { it.group }.toSet()

val groups: MutableList<Group> = mutableListOf(
    Group("21m"),
    Group("21z"),
    Group("21k"),
)