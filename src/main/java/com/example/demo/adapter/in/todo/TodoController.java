package com.example.demo.adapter.in.todo;

import com.example.demo.application.todo.command.CreateTodoCommand;
import com.example.demo.application.todo.command.CreateTodoHandler;
import com.example.demo.application.todo.query.GetTodoHandler;
import com.example.demo.domain.todo.model.Todo;
import com.example.demo.domain.todo.model.TodoWithUserNameDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todo")
public class TodoController {
    private final GetTodoHandler getTodoHandler;
private final CreateTodoHandler createTodoHandler;
    public TodoController(GetTodoHandler getTodoHandler, CreateTodoHandler createTodoHandler) {
        this.getTodoHandler = getTodoHandler;
        this.createTodoHandler = createTodoHandler;
    }

    @GetMapping
    public List<TodoWithUserNameDto> getAllTodo(){
        return getTodoHandler.handle();
    }
    @PostMapping
    public Todo saveTodo(@Valid @RequestBody CreateTodoCommand command){
        return createTodoHandler.handle(command);
    }
}
