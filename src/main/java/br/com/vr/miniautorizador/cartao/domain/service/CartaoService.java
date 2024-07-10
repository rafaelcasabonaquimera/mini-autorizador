package br.com.vr.miniautorizador.cartao.domain.service;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.specification.CartaoSpecification;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;

import java.math.BigDecimal;

public interface CartaoService {

    static Cartao fromInput(final InputCartao input) {
        final var entity =  Cartao.builder()
                .numeroCartao(input.getNumeroCartao())
                .senha(input.getSenha())
                .saldo(new BigDecimal(500))
                .build();

        CartaoSpecification.numeroCartaoIsNotEmtpy().check(entity);

        return entity;
    }

}
