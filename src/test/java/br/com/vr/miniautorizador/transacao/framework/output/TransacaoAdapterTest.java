package br.com.vr.miniautorizador.transacao.framework.output;

import br.com.vr.miniautorizador.cartao.framework.output.persist.CartaoRepository;
import br.com.vr.miniautorizador.cartao.framework.output.persist.data.CartaoData;
import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.framework.output.mappers.TransacaoMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
public class TransacaoAdapterTest {

    @Mock
    private CartaoRepository cartaoRepository;

    @InjectMocks
    private TransacaoAdapter transacaoAdapter;

    @Mock
    private TransacaoMapper transacaoMapper;

    @Test
    public void quandoPassado_transacaoComSaldo_retornaTransacaoRealizada() {
        final var numeroCartao = "6149873025634619";
        final var senhaCartao = "123123";
        final var transacao = Transacao.builder()
                .numeroCartao(numeroCartao)
                .senhaCartao(senhaCartao)
                .valor(new BigDecimal(10))
                .build();

        Mockito
                .when(cartaoRepository.findFirstByNumeroCartao(ArgumentMatchers.anyString()))
                .thenReturn(Mono.just(CartaoData.builder().numeroCartao(numeroCartao).senha(senhaCartao).saldo(new BigDecimal(500)).build()));
        Mockito
                .when(transacaoMapper.fromData(ArgumentMatchers.any()))
                .thenReturn(Mono.just(transacao));

        Mono<Transacao> transacaoMono = transacaoAdapter.atualizaSaldo(transacao);

        StepVerifier
                .create(transacaoMono)
                .expectNextMatches(expected -> expected.getValor().equals(new BigDecimal(10)))
                .expectComplete()
                .verify();
    }


}
