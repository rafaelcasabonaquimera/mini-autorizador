package br.com.vr.miniautorizador.transacao.framework.input.rest;

import br.com.vr.miniautorizador.transacao.application.usecases.TransacaoUseCase;
import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;
import br.com.vr.miniautorizador.transacao.domain.vo.InputTransacao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transacoes")
@AllArgsConstructor
public class TransacaoRest {

    private TransacaoUseCase transacaoUseCase;

    @PostMapping("/")
    public Mono<ResponseEntity<Transacao>> transacao(@RequestBody final InputTransacao input) {
        return transacaoUseCase.atualizaSaldo(input)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity("CARTAO_INEXISTENTE", HttpStatusCode.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value())));
    }

}
