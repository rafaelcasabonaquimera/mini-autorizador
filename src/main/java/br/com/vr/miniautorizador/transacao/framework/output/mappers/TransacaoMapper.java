package br.com.vr.miniautorizador.transacao.framework.output.mappers;

import br.com.vr.miniautorizador.cartao.framework.output.persist.data.CartaoData;
import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TransacaoMapper {

    public Mono<Transacao> fromData(final Mono<CartaoData> data) {
        return data.map(cartao -> Transacao.builder()
                .numeroCartao(cartao.getNumeroCartao())
                .senhaCartao(cartao.getSenha())
                .valor(cartao.getSaldo())
                .build());
    }

}
