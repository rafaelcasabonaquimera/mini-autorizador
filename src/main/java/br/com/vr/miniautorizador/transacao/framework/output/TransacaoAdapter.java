package br.com.vr.miniautorizador.transacao.framework.output;

import br.com.vr.miniautorizador.cartao.framework.output.persist.CartaoRepository;
import br.com.vr.miniautorizador.shared.domain.exception.ErroSenhaException;
import br.com.vr.miniautorizador.shared.domain.exception.SaldoInsuficienteException;
import br.com.vr.miniautorizador.transacao.application.ports.output.TransacaoOutput;
import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.domain.service.TransacaoService;
import br.com.vr.miniautorizador.transacao.framework.output.mappers.TransacaoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class TransacaoAdapter implements TransacaoOutput {

    private CartaoRepository repository;

    private TransacaoMapper transacaoMapper;
    @Override
    @Transactional
    public Mono<Transacao> atualizaSaldo(final Transacao entity) {
        return transacaoMapper.fromData(repository.findFirstByNumeroCartao(entity.getNumeroCartao())
                .flatMap(optional ->
                        TransacaoService.passwordValid(optional.getSenha(), entity.getSenhaCartao())
                                ? Mono.error(new ErroSenhaException("SENHA_INVALIDA"))
                                : Mono.just(optional))
                .flatMap(optional ->
                                TransacaoService.hasABalance(optional.getSaldo(), entity.getValor())
                                    ? Mono.error(new SaldoInsuficienteException("SALDO_INSUFICIENTE"))
                                    : Mono.just(optional))
                .flatMap(optional -> {
                    optional.setSaldo(optional.getSaldo().subtract(entity.getValor()));
                    return repository.save(optional);
                }));

    }

}
