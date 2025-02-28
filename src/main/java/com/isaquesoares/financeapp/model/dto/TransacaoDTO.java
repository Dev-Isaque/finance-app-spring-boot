package com.isaquesoares.financeapp.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigDecimalDeserializer;
import com.isaquesoares.financeapp.enums.CategoriaTransacao;
import com.isaquesoares.financeapp.enums.FormaPagamento;
import com.isaquesoares.financeapp.enums.TipoTransacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDTO {
    private TipoTransacao tipo;
    @JsonDeserialize(using = BigDecimalDeserializer.class)
    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate data;
    private CategoriaTransacao categoria;
    private String descricao;
    private FormaPagamento formaPagamento;
    private Long userId;
}
