package com.isaquesoares.financeapp.services;

import com.isaquesoares.financeapp.model.Transacao;
import com.isaquesoares.financeapp.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTodas() {
        return transacaoRepository.findAll();
    }
}
