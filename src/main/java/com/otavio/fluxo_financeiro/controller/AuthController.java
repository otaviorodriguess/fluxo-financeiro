package com.otavio.fluxo_financeiro.controller;

import com.otavio.fluxo_financeiro.dto.LoginRequest;
import com.otavio.fluxo_financeiro.dto.LoginResponse;
import com.otavio.fluxo_financeiro.model.User;
import com.otavio.fluxo_financeiro.service.UserService;
import com.otavio.fluxo_financeiro.security.JwtUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Cadastro de usuário
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.salvar(user);
    }

    // Login e geração de token
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userService.buscarPorEmail(request.getEmail());
        if (user != null && user.getSenha().equals(request.getSenha())) {
            String token = JwtUtil.generateToken(user.getEmail());
            return new LoginResponse(token);
        }
        throw new RuntimeException("Credenciais inválidas");
    }

    // Endpoint para testar usuário
    @GetMapping("/me")
    public String me() {
        return "Usuário autenticado: " +
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
