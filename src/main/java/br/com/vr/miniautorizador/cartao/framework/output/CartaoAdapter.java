package br.com.vr.miniautorizador.cartao.framework.output;

import br.com.vr.miniautorizador.cartao.application.ports.output.CartaoOutput;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.framework.output.persist.CartaoRepository;
import br.com.vr.miniautorizador.cartao.framework.output.persist.mappers.CartaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class CartaoAdapter implements CartaoOutput {

    private CartaoRepository repository;

    private CartaoMapper mapper;

    @Override
    public Mono<Cartao> create(final Cartao entity) {
        final var entitySave = mapper.fromData(repository.save(mapper.toData(entity)));
        return entitySave;
    }

    @Override
    public Mono<Cartao> getByNumeroCartao(final String numeroCartao) {
        return mapper.fromData(repository.findFirstByNumeroCartao(numeroCartao));
    }

    @Override
    public Mono<BigDecimal> getSaldo(final String numeroCartao) {
        return mapper.fromDataSaldo(repository.findFirstByNumeroCartao(numeroCartao));
    }

}
