package br.com.vr.miniautorizador.cartao.application.ports.output;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import reactor.core.publisher.Mono;

public interface CartaoOutput {

    Mono<Cartao> create(final Cartao entity);

    Mono<Cartao> getByNumeroCartao(final String numeroCartao);

}
