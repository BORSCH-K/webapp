package ru.altmanea.webapp.rest

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ru.altmanea.webapp.config.Config
import ru.altmanea.webapp.repo.groups
import ru.altmanea.webapp.repo.students

fun Route.studentRoutes() {
    route(Config.studentsPath) { // Строит маршрут в соответствии с указанным путем.
        get { // Строит маршрут в соответствии с запросами GET.
            if (students.isEmpty()) {
                call.respondText("No students found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(students)
            }
        }
    }
}
fun Route.groupRoutes() {
    route(Config.groupsPath){
        get {
            if (groups.isEmpty()){
                call.respondText("No students found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(groups)
            }
        }
    }
}