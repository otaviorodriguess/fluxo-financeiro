package com.otavio.fluxo_financeiro.controller;

import com.otavio.fluxo_financeiro.model.Transaction;
import com.otavio.fluxo_financeiro.model.Tipo;
import com.otavio.fluxo_financeiro.model.User;
import com.otavio.fluxo_financeiro.service.TransactionService;
import com.otavio.fluxo_financeiro.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class ResumoFinanceiroController {

    private final TransactionService transactionService;
    private final UserService userService;

    public ResumoFinanceiroController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/resumo")
    public ResumoDTO resumo() {
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.buscarPorEmail(email);

        List<Transaction> transacoes = transactionService.listarPorUsuario(user.getId());

        double receitas = transacoes.stream()
                .filter(t -> t.getTipo() == Tipo.RECEITA)
                .mapToDouble(Transaction::getValor)
                .sum();

        double despesas = transacoes.stream()
                .filter(t -> t.getTipo() == Tipo.DESPESA)
                .mapToDouble(Transaction::getValor)
                .sum();

        double saldo = receitas - despesas;

        return new ResumoDTO(receitas, despesas, saldo);
    }

    // DTO interno para resposta
    public static class ResumoDTO {
        private double receitas;
        private double despesas;
        private double saldo;

        public ResumoDTO(double receitas, double despesas, double saldo) {
            this.receitas = receitas;
            this.despesas = despesas;
            this.saldo = saldo;
        }

        public double getReceitas() { return receitas; }
        public double getDespesas() { return despesas; }
        public double getSaldo() { return saldo; }
    }
}
