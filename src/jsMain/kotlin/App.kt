import component.containerGroupList
import component.containerStudentList
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import react.router.dom.Link
import tanstack.query.core.QueryClient
import tanstack.react.query.QueryClientProvider
import web.dom.document

//val queryClient = QueryClient() // доп способ взаимодействия с запросами

fun main() {
    val container = document.getElementById("root")!!
    createRoot(container).render(app.create())
}

val app = FC<Props>("App") {

    QueryClientProvider {   // для создания запросов и получения ответов
                            // спользуется для подключения и передачи QueryClient в приложение
        client = QueryClient() // доступ клиенту

        BrowserRouter {
            div {
                Link {
                    +"students"
                    to = "students"
                }
                Link {
                    +"groups"
                    to = "groups"
                }
            }
            Routes {
                Route {
                    path = "/students/"
                    element = containerStudentList.create()
                }
                Route {
                    path = "/groups/"
                    element = containerGroupList.create()
                }
            }
        }
    }
}

