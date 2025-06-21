package com.example.demo.adapter.in.user;


import com.example.demo.application.user.command.CreateUserCommand;
import com.example.demo.application.user.command.CreateUserHandler;
import com.example.demo.application.user.query.GetAllUsersHandler;
import com.example.demo.application.user.query.GetAllUsersQuery;
import com.example.demo.application.user.query.GetUserHandler;
import com.example.demo.application.user.query.GetUserQuery;
import com.example.demo.domain.user.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserHandler createUserHandler;
    private final GetUserHandler getUserHandler;
    private final GetAllUsersHandler getAllUsersHandler;

    public UserController(CreateUserHandler createUserHandler, GetUserHandler getUserHandler, GetAllUsersHandler getAllUsersHandler) {
        this.createUserHandler = createUserHandler;
        this.getUserHandler = getUserHandler;
        this.getAllUsersHandler = getAllUsersHandler;
    }

    @PostMapping
    public void createUser(@RequestBody CreateUserCommand command) {
        createUserHandler.handle(command);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return getUserHandler.handle(new GetUserQuery(id));
    }
    @GetMapping("/")
    public List<User> getAllUsers(){
        return getAllUsersHandler.handle(new GetAllUsersQuery());
    }
}
