package br.com.vr.miniautorizador.cartao.application.ports.input;

import br.com.vr.miniautorizador.cartao.application.ports.output.CartaoOutput;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import br.com.vr.miniautorizador.shared.domain.exception.CartaoExistenteException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
public class CartaoInputTest {

    @Mock
    private CartaoOutput cartaoOutput;

    @InjectMocks
    private CartaoInput useCase;

    @Test
    public void quandoPassado_cartaoExistente_retornaCartaoJaExistente() {
        final var numeroCartao = "6149873025634619";
        final var input = InputCartao.builder()
                .numeroCartao(numeroCartao)
                .build();

        Mockito
                .when(cartaoOutput.getByNumeroCartao(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(Cartao.builder().build()));
        Mono<Cartao> cartaoMono = useCase.create(input);

        StepVerifier
                .create(cartaoMono)
                .expectErrorMatches(error -> error instanceof CartaoExistenteException)
                .verify();
    }

}
