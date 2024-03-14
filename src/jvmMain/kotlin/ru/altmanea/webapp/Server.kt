package ru.altmanea.webapp

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import ru.altmanea.webapp.rest.groupRoutes
import ru.altmanea.webapp.rest.studentRoutes

fun main() {
    embeddedServer(  // Создает встроенный сервер и запускает приложение
        Netty,
        port = 8080,
        host = "127.0.0.1",
        watchPaths = listOf("classes")
    ) {
        main()
    }.start(wait = true)
}

fun Application.main() {
    config()
    static() // статический маршрут
    rest()
//    logRoute()
}

fun Application.config() {
    install(ContentNegotiation) { // ContentNegotiation - плагин для де-/сериализации
        json()  // запросы-ответы в формате json
    }
}

fun Application.rest() {
    routing { // url-маршруты клиентской части
        studentRoutes()
        groupRoutes()
    }
}