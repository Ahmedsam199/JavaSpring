package com.example.demo.adapter.out.todo;

import com.example.demo.domain.todo.model.Todo;
import com.example.demo.domain.todo.model.TodoWithUserNameDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpringDataTodoRepository extends JpaRepository<Todo,Long> {
    @Query("SELECT new com.example.demo.domain.todo.model.TodoWithUserNameDto(t.id, t.title, t.done, t.date, t.user.name, t.user.email) FROM Todo t")
    List<TodoWithUserNameDto> findAllWithUserName();

}
