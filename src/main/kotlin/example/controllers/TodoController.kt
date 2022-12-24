package example.controllers

import example.domain.Todo
import example.repositories.TodoRepository
import example.services.TodoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.views.View
import jakarta.inject.Inject
import java.net.URI

@Controller
class TodoController(@Inject val todoService: TodoService) {
    @Get("/index")
    @View("index")
    fun index(): HttpResponse<*> {
        val dataList = todoService.findAllTodos()
        return HttpResponse.ok(mapOf("dataList" to dataList))
    }

    @Post("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun add(@Body("text") text: String): HttpResponse<*> {
        val todo = Todo(0, text)
        todoService.save(todo)
        return HttpResponse.redirect<Any>(URI.create("/index"))
    }

    @Post("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun delete(@Body("id") id: Long): HttpResponse<*> {
        todoService.delete(id)
        return HttpResponse.redirect<Any>(URI.create("/index"))
    }
}
