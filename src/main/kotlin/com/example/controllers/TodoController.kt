package com.example.controllers

import com.example.domain.TodoEntry
import com.example.repositories.TodoRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.views.View
import jakarta.inject.Inject
import java.net.URI

@Controller
class TodoController {
    @Inject
    lateinit var todoRepository: TodoRepository

    @Get("/index")
    @View("index")
    fun index(): HttpResponse<*> {
        val dataList = todoRepository.findAll()
        return HttpResponse.ok(mapOf("dataList" to dataList))
    }

    @Post("/add")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun add(@Body("text") text: String): HttpResponse<*> {
        val data = TodoEntry(0, text)
        todoRepository.save(data)
        return HttpResponse.redirect<Any>(URI.create("/index"))
    }

    @Post("/delete")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun delete(@Body("id") id: Long): HttpResponse<*> {
        todoRepository.deleteById(id)
        return HttpResponse.redirect<Any>(URI.create("/index"))
    }
}