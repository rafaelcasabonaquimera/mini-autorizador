package br.com.vr.miniautorizador.cartao.application.ports.input;

import br.com.vr.miniautorizador.cartao.application.usecases.CartaoUseCase;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.service.CartaoService;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import br.com.vr.miniautorizador.cartao.framework.output.CartaoAdapter;
import br.com.vr.miniautorizador.shared.domain.exception.CartaoExistenteException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CartaoInput implements CartaoUseCase {

    private CartaoAdapter adapter;
    @Override
    public Mono<Cartao> create(final InputCartao input) {
        return this.getByNumeroCartao(input.getNumeroCartao())
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(optionalCartao -> {
                    if (optionalCartao.isPresent()) {
                        return Mono.error(new CartaoExistenteException("Cartão já existe", optionalCartao.get()));
                    }
                    return adapter.create(CartaoService.fromInput(input));
                });
    }

    @Override
    public Mono<Cartao> getByNumeroCartao(final String numeroCartao) {
        return adapter.getByNumeroCartao(numeroCartao);
    }

    @Override
    public Mono<BigDecimal> getSaldo(final String numeroCartao) {
        return adapter.getSaldo(numeroCartao);
    }
}
