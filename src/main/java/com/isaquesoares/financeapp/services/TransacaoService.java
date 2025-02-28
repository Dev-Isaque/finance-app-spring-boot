package com.isaquesoares.financeapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isaquesoares.financeapp.model.Transacao;
import com.isaquesoares.financeapp.repository.TransacaoRepository;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> listarTodas(Long userId) {
        return transacaoRepository.findByUsuario_Id(userId);
    }

    public deletarService(Transacao Transacao) {
        return transacaoRepository.delete(Transacao);(transacao);
    }

}
