package ru.altmanea.webapp

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import kotlinx.html.*

fun HTML.index() {
    head {
        title("WebApp")
    }
    body {
        div {
            id = "root"
            +"React will be here!!"
        }
        script(src = "/static/webapp.js") {}
    }
}

fun Application.static() {
    routing {
        get("/") {
            call
                .respondHtml(HttpStatusCode.OK, HTML::index) // ответ в виде html-файла
        }
        static("/static") {
            resources()
        }
    }
}
