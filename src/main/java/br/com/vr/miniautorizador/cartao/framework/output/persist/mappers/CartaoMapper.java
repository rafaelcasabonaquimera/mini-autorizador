package br.com.vr.miniautorizador.cartao.framework.output.persist.mappers;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.framework.output.persist.data.CartaoData;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class CartaoMapper {

    public CartaoData toData(final Cartao entity) {
        return CartaoData.builder()
                .numeroCartao(entity.getNumeroCartao())
                .senha(entity.getSenha())
                .saldo(entity.getSaldo())
                .build();
    }

    public Mono<Cartao> fromData(final Mono<CartaoData> data) {
        return data.map(cartao -> Cartao.builder()
                .numeroCartao(cartao.getNumeroCartao())
                .senha(cartao.getSenha())
                .build());
    }

    public Mono<BigDecimal> fromDataSaldo(final Mono<CartaoData> data) {
        return data.map(cartao -> cartao.getSaldo());
    }

}
