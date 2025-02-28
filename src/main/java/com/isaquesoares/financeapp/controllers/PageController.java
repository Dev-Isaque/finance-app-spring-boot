package com.isaquesoares.financeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPageAgain() {
        return "login";
    }

    @GetMapping("/esqueci-senha")
    public String showEsqueciSenhaPage() {
        return "esqueci-senha";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("title", "Dashboard - FinanceApp");
        return "index";
    }

    @GetMapping("/adicionar-transacao")
    public String showAdicionarTransacaoPage(Model model) {
        model.addAttribute("title", "Adiconar Transação - FinanceApp");
        return "adicionar-transacao";
    }
}