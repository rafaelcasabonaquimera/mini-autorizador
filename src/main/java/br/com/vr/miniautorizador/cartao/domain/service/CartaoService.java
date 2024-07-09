package br.com.vr.miniautorizador.cartao.domain.service;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.specification.CartaoSpecification;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;

public interface CartaoService {

    static Cartao fromInput(final InputCartao input) {
        final var data =  Cartao.builder()
                .numeroCartao(input.getNumeroCartao())
                .senha(input.getSenha())
                .build();

        CartaoSpecification.numeroCartaoIsNotEmtpy().check(data);

        return data;
    }

}
