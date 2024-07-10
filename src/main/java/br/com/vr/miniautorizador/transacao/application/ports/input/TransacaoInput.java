package br.com.vr.miniautorizador.transacao.application.ports.input;

import br.com.vr.miniautorizador.transacao.application.ports.output.TransacaoOutput;
import br.com.vr.miniautorizador.transacao.application.usecases.TransacaoUseCase;
import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.domain.service.TransacaoService;
import br.com.vr.miniautorizador.transacao.domain.vo.InputTransacao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class TransacaoInput implements TransacaoUseCase {

    private TransacaoOutput transacaoOutput;

    @Override
    public Mono<Transacao> atualizaSaldo(final InputTransacao input) {
        return transacaoOutput.atualizaSaldo(TransacaoService.fromInput(input));
    }
}
