package br.com.vr.miniautorizador.cartao.framework.output.persist;

import br.com.vr.miniautorizador.cartao.framework.output.persist.data.CartaoData;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CartaoRepository extends ReactiveCrudRepository<CartaoData, String> {

    Mono<CartaoData> findFirstByNumeroCartao(final String numeroCartao);

}
