package com.example.demo.users;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(
            name = "StudentIdSeq", // this must match below
            sequenceName = "user_id_seq", // the actual DB sequence name
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq"
    )
    private Long id;
    @NotNull(message = "Required Field")

    private String name;
    @NotNull(message = "Required Field")

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(Long id,String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {
    }
}
