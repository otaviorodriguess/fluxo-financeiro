package com.otavio.fluxo_financeiro.service;

import com.otavio.fluxo_financeiro.model.User;
import com.otavio.fluxo_financeiro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User salvar(User user) {
        return repository.save(user);
    }

    public List<User> listarTodos() {
        return repository.findAll();
    }

    public User buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
