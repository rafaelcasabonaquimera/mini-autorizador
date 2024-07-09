package br.com.vr.miniautorizador.cartao.application.ports.input;

import br.com.vr.miniautorizador.cartao.application.usecases.CartaoUseCase;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.service.CartaoService;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import br.com.vr.miniautorizador.cartao.framework.output.CartaoAdapter;
import br.com.vr.miniautorizador.shared.domain.exception.CartaoExistenteException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CartaoInput implements CartaoUseCase {

    private CartaoAdapter adapter;
    @Override
    public Mono<Cartao> create(final InputCartao input) {
        return this.getByNumeroCartao(input.getNumeroCartao())
                .switchIfEmpty(
                        adapter.create(CartaoService.fromInput(input)));
    }

    @Override
    public Mono<Cartao> getByNumeroCartao(String numeroCartao) {
        return adapter.getByNumeroCartao(numeroCartao);
    }
}
