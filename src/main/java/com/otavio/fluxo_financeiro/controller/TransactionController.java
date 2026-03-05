package com.otavio.fluxo_financeiro.controller;

import com.otavio.fluxo_financeiro.model.Transaction;
import com.otavio.fluxo_financeiro.model.User;
import com.otavio.fluxo_financeiro.service.TransactionService;
import com.otavio.fluxo_financeiro.service.UserService;
import com.otavio.fluxo_financeiro.security.JwtUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    // Criar transação vinculada ao usuário autenticado
    @PostMapping
    public Transaction criar(@RequestBody Transaction transaction) {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.buscarPorEmail(email);
        transaction.setUser(user);
        return transactionService.salvar(transaction);
    }

    // Listar transações do usuário autenticado
    @GetMapping
    public List<Transaction> listar() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.buscarPorEmail(email);
        return transactionService.listarPorUsuario(user.getId());
    }
}
