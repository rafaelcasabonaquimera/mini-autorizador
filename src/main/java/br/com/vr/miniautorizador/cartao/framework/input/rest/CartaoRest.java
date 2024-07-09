package br.com.vr.miniautorizador.cartao.framework.input.rest;

import br.com.vr.miniautorizador.cartao.application.usecases.CartaoUseCase;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@RestController
@RequestMapping("/cartoes")
@AllArgsConstructor
public class CartaoRest {

    private CartaoUseCase cartaoUseCase;

    @PostMapping("/")
    public ResponseEntity<Mono<Cartao>> create(@RequestBody final InputCartao input) {
        final var create = cartaoUseCase.create(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

}
