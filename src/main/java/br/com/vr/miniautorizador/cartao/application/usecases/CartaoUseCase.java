package br.com.vr.miniautorizador.cartao.application.usecases;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface CartaoUseCase {

    /**
     * Adiciona um novo cartão
     * @param input
     * @return Cartao
     */
    Mono<Cartao> create(final InputCartao input);

    Mono<Cartao> getByNumeroCartao(final String numeroCartao);

    Mono<BigDecimal> getSaldo(final String numeroCartao);

}
