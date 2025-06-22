package com.example.demo.application.todo.command;

import java.time.LocalDate;

public record CreateTodoCommand(String title, LocalDate date,Boolean done,Long userId) {

}
