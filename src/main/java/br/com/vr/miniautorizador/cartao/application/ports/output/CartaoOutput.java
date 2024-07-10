package br.com.vr.miniautorizador.cartao.application.ports.output;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface CartaoOutput {

    Mono<Cartao> create(final Cartao entity);

    Mono<Cartao> getByNumeroCartao(final String numeroCartao);

    Mono<BigDecimal> getSaldo(final String numeroCartao);

}
