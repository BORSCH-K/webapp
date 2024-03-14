package component

import ru.altmanea.webapp.data.Student
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import react.FC
import react.Props
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import ru.altmanea.webapp.config.Config
import tanstack.query.core.QueryKey
import tanstack.react.query.useQuery
import tools.fetchText
import react.dom.html.ReactHTML.div
import ru.altmanea.webapp.data.Group


external interface QueryError

external interface StudentListProps : Props {
    var students: Array<Student>
}

external interface GroupListProps : Props {
    var groups: Array<String>
}


val CStudentList = FC<StudentListProps>("StudentList") { props ->

    ol {
        props.students.forEach { student ->
            li {
                CStudentItem {
                    this.student = student
                }
            }
        }
    }
}

val CGroupList = FC<GroupListProps> { props ->
    ol {
        props.groups.forEach { student ->
            li { +student }
        }
    }
}

val containerStudentList = FC<Props>("QueryStudentList") {
    val query = useQuery<String, QueryError, String, QueryKey>( // Хук принимает массив объектов с настройками запроса и возвращает массив результатов выполнения этих запросов.
        queryKey = arrayOf("studentList").unsafeCast<QueryKey>(), // уникальная строка или массив: ключ для идентификации запроса
        queryFn = { // функция для получения данных
            fetchText(Config.studentsPath) // обращается к серверу по адресу
        }
    )

    if (query.isLoading) div { +"Loading ..." }
    else if (query.isError) div { +"Error!" }
    else {
        val items = Json.decodeFromString<Array<Student>>(query.data ?: "")
        console.log(items)

        CStudentList { students = items }
    }
}


val containerGroupList = FC<Props>("QueryGroupList") {
    val query = useQuery<String, QueryError, String, QueryKey>(
        queryKey = arrayOf("groupList").unsafeCast<QueryKey>(),
        queryFn = {
            fetchText(Config.groupsPath) // обращается к серверу по адресу
        }
    )

    if (query.isLoading) div { +"Loading ..." }
    else if (query.isError) div { +"Error!" }
    else {
        val items = Json.decodeFromString<Array<Group>>(query.data ?: "")
        console.log(items)

        CGroupList { groups = items.map { it.name }.toTypedArray() }
    }
}
