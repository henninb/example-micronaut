package example.repositories

import example.domain.Todo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

//@Repository
//interface TodoRepository : CrudRepository<TodoEntry, Long>

@Repository
interface TodoRepository : JpaRepository<Todo, Long> {

}