package br.com.vr.miniautorizador.transacao.domain.service;

import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.domain.vo.InputTransacao;

import java.math.BigDecimal;

public interface TransacaoService {

    static Transacao fromInput(final InputTransacao input) {
        final var entity = Transacao.builder()
                .numeroCartao(input.getNumeroCartao())
                .senhaCartao(input.getSenhaCartao())
                .valor(input.getValor())
                .build();

        return entity;
    }

    static Boolean hasABalance(final BigDecimal saldo, final BigDecimal retirada) {
        return saldo.compareTo(retirada) < 0;
    }

    static Boolean passwordValid(final String pass, final String inputPass) {
        return !pass.equals(inputPass);
    }

}
