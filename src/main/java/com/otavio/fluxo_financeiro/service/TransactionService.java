package com.otavio.fluxo_financeiro.service;

import com.otavio.fluxo_financeiro.model.Transaction;
import com.otavio.fluxo_financeiro.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction salvar(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> listarPorUsuario(Long userId) {
        return repository.findByUserId(userId);
    }
}
