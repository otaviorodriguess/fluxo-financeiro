package com.otavio.fluxo_financeiro.controller;

import com.otavio.fluxo_financeiro.model.User;
import com.otavio.fluxo_financeiro.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public User criar(@RequestBody User user) {
        return service.salvar(user);
    }

    @GetMapping
    public List<User> listar() {
        return service.listarTodos();
    }
}
