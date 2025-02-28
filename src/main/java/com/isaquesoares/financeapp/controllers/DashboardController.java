package com.isaquesoares.financeapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Simulando dados financeiros
        double saldoAtual = 10500.75;
        double receitaMes = 4500.00;
        double despesaMes = 2800.50;

        List<Map<String, Object>> transacoes = List.of(
                Map.of("data", "2025-02-10", "descricao", "Salário", "valor", "+3000.00"),
                Map.of("data", "2025-02-12", "descricao", "Conta de Luz", "valor", "-150.00"),
                Map.of("data", "2025-02-14", "descricao", "Compra Online", "valor", "-320.00"));

        model.addAttribute("saldoAtual", saldoAtual);
        model.addAttribute("receitaMes", receitaMes);
        model.addAttribute("despesaMes", despesaMes);
        model.addAttribute("transacoes", transacoes);

        return "dashboard";
    }
}
