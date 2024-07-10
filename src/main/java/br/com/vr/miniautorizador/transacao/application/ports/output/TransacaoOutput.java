package br.com.vr.miniautorizador.transacao.application.ports.output;

import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import reactor.core.publisher.Mono;

public interface TransacaoOutput {

    Mono<Transacao> atualizaSaldo(final Transacao entity);

}
