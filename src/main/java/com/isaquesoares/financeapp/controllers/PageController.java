package com.isaquesoares.financeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String showLoginPage() {
        return "/auth/login";
    }

    @GetMapping("/auth/login")
    public String showLoginPageAgain() {
        return "auth/login";
    }

    @GetMapping("/auth/esqueci-senha")
    public String showEsqueciSenhaPage() {
        return "auth/esqueci-senha";
    }

    @GetMapping("/auth/register")
    public String showRegisterPage() {
        return "auth/register";
    }

    @GetMapping("/view/index")
    public String showIndexPage(Model model) {
        model.addAttribute("title", "Dashboard - FinanceApp");
        return "/view/index";
    }

    @GetMapping("/view/adicionar-transacao")
    public String showAdicionarTransacaoPage(Model model) {
        model.addAttribute("title", "Adiconar Transação - FinanceApp");
        return "view/adicionar-transacao";
    }

    @GetMapping("/view/visualizar-transacao")
    public String showVisualizarTransacaoPage(Model model) {
        model.addAttribute("title", "Visualizar Transação - FinanceApp");
        return "view/visualizar-transacao";
    }
}