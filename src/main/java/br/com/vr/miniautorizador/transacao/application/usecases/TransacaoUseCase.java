package br.com.vr.miniautorizador.transacao.application.usecases;

import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.domain.vo.InputTransacao;
import reactor.core.publisher.Mono;

public interface TransacaoUseCase {

    Mono<Transacao> atualizaSaldo(final InputTransacao input);

}
