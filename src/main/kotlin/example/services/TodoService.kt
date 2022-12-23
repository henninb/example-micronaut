package example.services

import example.domain.Todo
import example.repositories.TodoRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class TodoService(@Inject val todoRepository: TodoRepository) {
    fun findAllTodos() : List<Todo> {
        return todoRepository.findAll()
    }

    fun save(todo: Todo) {
        todoRepository.save(todo)
    }

    fun delete(id: Long) {
        todoRepository.deleteById(id)
    }

}