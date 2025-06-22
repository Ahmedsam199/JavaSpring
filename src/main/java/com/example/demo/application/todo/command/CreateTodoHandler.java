package com.example.demo.application.todo.command;

import com.example.demo.adapter.out.todo.JpaTodoAdapter;
import com.example.demo.adapter.out.user.JpaUserAdapter;
import com.example.demo.domain.todo.model.Todo;
import com.example.demo.domain.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class CreateTodoHandler {
    private final JpaTodoAdapter jpaTodoAdapter;
private final JpaUserAdapter jpaUserAdapter;
    public CreateTodoHandler(JpaTodoAdapter jpaTodoAdapter, JpaUserAdapter jpaUserAdapter) {
        this.jpaTodoAdapter = jpaTodoAdapter;
        this.jpaUserAdapter = jpaUserAdapter;
    }
    public Todo handle(CreateTodoCommand command){

        User user = jpaUserAdapter.findById(command.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Todo todo = new Todo();
        todo.setTitle(command.title());
        todo.setDate(command.date());
        todo.setDone(command.done());
        todo.setUser(user);

        return jpaTodoAdapter.saveTodo(todo);    }

}
