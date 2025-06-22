package com.example.demo.application.todo.query;

import com.example.demo.adapter.out.todo.JpaTodoAdapter;
import com.example.demo.domain.todo.model.TodoWithUserNameDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTodoHandler {
    private final JpaTodoAdapter jpaTodoAdapter;

    public GetTodoHandler(JpaTodoAdapter jpaTodoAdapter) {
        this.jpaTodoAdapter = jpaTodoAdapter;
    }
    public List<TodoWithUserNameDto> handle(){
        return jpaTodoAdapter.getAllTodo();
    }
}
