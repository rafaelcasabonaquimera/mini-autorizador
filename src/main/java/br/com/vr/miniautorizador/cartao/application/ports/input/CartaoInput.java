package br.com.vr.miniautorizador.cartao.application.ports.input;

import br.com.vr.miniautorizador.cartao.application.ports.output.CartaoOutput;
import br.com.vr.miniautorizador.cartao.application.usecases.CartaoUseCase;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.service.CartaoService;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import br.com.vr.miniautorizador.shared.domain.exception.CartaoExistenteException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CartaoInput implements CartaoUseCase {

    private CartaoOutput cartaoOutput;
    @Override
    public Mono<Cartao> create(final InputCartao input) {
        return this.getByNumeroCartao(input.getNumeroCartao())
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(cartao -> cartao.isPresent()
                        ? Mono.error(new CartaoExistenteException("Cartão já existe", cartao.get()))
                        : cartaoOutput.create(CartaoService.fromInput(input)));
    }

    @Override
    public Mono<Cartao> getByNumeroCartao(final String numeroCartao) {
        final var cartao = cartaoOutput.getByNumeroCartao(numeroCartao);
        return cartao;
    }

    @Override
    public Mono<BigDecimal> getSaldo(final String numeroCartao) {
        return cartaoOutput.getSaldo(numeroCartao);
    }
}
