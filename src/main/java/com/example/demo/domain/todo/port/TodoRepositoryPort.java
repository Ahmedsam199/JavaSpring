package com.example.demo.domain.todo.port;

import com.example.demo.domain.todo.model.Todo;
import com.example.demo.domain.todo.model.TodoWithUserNameDto;

import java.util.List;

public interface TodoRepositoryPort {
    List<TodoWithUserNameDto> getAllTodo();
    Todo saveTodo(Todo todo);
}
