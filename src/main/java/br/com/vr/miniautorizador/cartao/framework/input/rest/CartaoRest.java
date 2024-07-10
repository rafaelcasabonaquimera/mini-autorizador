package br.com.vr.miniautorizador.cartao.framework.input.rest;

import br.com.vr.miniautorizador.cartao.application.usecases.CartaoUseCase;
import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.cartao.domain.vo.InputCartao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cartoes")
@AllArgsConstructor
public class CartaoRest {

    private CartaoUseCase cartaoUseCase;

    @PostMapping("/")
    public Mono<ResponseEntity<Cartao>> create(@RequestBody final InputCartao input) {
        return cartaoUseCase.create(input).map(ResponseEntity::ok);
    }

    @GetMapping("/{numeroCartao}")
    public Mono<ResponseEntity<BigDecimal>> getSaldo(@PathVariable("numeroCartao") final String numeroCartao) {
        return cartaoUseCase.getSaldo(numeroCartao)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
