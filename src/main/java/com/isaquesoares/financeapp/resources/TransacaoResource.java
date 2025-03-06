package com.isaquesoares.financeapp.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isaquesoares.financeapp.model.Transacao;
import com.isaquesoares.financeapp.model.User;
import com.isaquesoares.financeapp.model.dto.TransacaoDTO;
import com.isaquesoares.financeapp.services.TransacaoService;
import com.isaquesoares.financeapp.services.UserService;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private UserService userService;

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, String>> salvarTransacao(@RequestBody TransacaoDTO transacaoDTO) {
        Map<String, String> response = new HashMap<>();

        if (transacaoDTO.getUserId() == null) {
            response.put("message", "Erro: userId não pode ser nulo!");
            return ResponseEntity.badRequest().body(response);
        }

        Long userId;
        try {
            userId = Long.valueOf(transacaoDTO.getUserId());
        } catch (NumberFormatException e) {
            response.put("message", "Erro: userId inválido!");
            return ResponseEntity.badRequest().body(response);
        }

        User user = userService.findById(userId);
        if (user == null) {
            response.put("message", "Erro: Usuário não encontrado!");
            return ResponseEntity.badRequest().body(response);
        }

        Transacao transacao = new Transacao();
        transacao.setTipo(transacaoDTO.getTipo());
        transacao.setValor(transacaoDTO.getValor());
        transacao.setData(transacaoDTO.getData());
        transacao.setCategoria(transacaoDTO.getCategoria());
        transacao.setDescricao(transacaoDTO.getDescricao());
        transacao.setFormaPagamento(transacaoDTO.getFormaPagamento());
        transacao.setUsuario(user);

        transacaoService.salvar(transacao);
        response.put("message", "Transação cadastrada com sucesso!");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar-transacoes")
    public ResponseEntity<List<Transacao>> listarTransacoes(@RequestParam Long userId) {
        List<Transacao> transacoes = transacaoService.listarTodas(userId);

        if (transacoes.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se não houver transações
        }
        return ResponseEntity.ok(transacoes);
    }

    @DeleteMapping("/deletar-transacao")
    public ResponseEntity<Void> deletarTransacao(@RequestParam Long transacaoId) {
        boolean deletado = transacaoService.deletarTransacao(transacaoId);
        if (!deletado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
