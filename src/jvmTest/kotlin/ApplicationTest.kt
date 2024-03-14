//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.http.*
//import io.ktor.server.testing.*
//import kotlinx.serialization.decodeFromString
//import kotlinx.serialization.json.Json
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.Test
//import ru.altmanea.webapp.config.Config
//import ru.altmanea.webapp.data.Student
//import ru.altmanea.webapp.main
//
//class ApplicationTest {
//    @Test
//    fun testStudentRoutes() = testApplication {
//        application { main() }
//        val response = client.get(Config.studentsPath)
//        assertEquals(HttpStatusCode.OK, response.status)
//        val students = Json.decodeFromString<List<Student>>(response.bodyAsText())
//        assertEquals(students.size, 4)
//    }
//}