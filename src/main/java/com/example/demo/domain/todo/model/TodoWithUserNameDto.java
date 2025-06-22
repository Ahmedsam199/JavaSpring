package com.example.demo.domain.todo.model;

public class TodoWithUserNameDto {
    private Long id;
    private String title;
    private Boolean done;
    private java.time.LocalDate date;
    private String userName;
    private String email;

    public TodoWithUserNameDto(Long id, String title, Boolean done, java.time.LocalDate date, String userName,String email) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.date = date;
        this.userName = userName;
        this.email= email;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Boolean getDone() { return done; }
    public java.time.LocalDate getDate() { return date; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
}
