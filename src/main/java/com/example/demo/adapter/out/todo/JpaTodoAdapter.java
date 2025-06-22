package com.example.demo.adapter.out.todo;

import com.example.demo.domain.todo.model.Todo;
import com.example.demo.domain.todo.model.TodoWithUserNameDto;
import com.example.demo.domain.todo.port.TodoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class JpaTodoAdapter implements TodoRepositoryPort {
    private final SpringDataTodoRepository springDataTodoRepository;

    public JpaTodoAdapter(SpringDataTodoRepository springDataTodoRepository) {
        this.springDataTodoRepository = springDataTodoRepository;
    }

    @Override
    public List<TodoWithUserNameDto> getAllTodo() {
        return springDataTodoRepository.findAllWithUserName();
    }

    @Override
    public Todo saveTodo(Todo todo) {
        return springDataTodoRepository.save(todo);
    }

}
