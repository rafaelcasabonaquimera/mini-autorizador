package br.com.vr.miniautorizador.shared.domain.exception;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CartaoExistenteException.class)
    protected ResponseEntity<Cartao> handleNotFound(CartaoExistenteException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getCartao());
    }
    @ExceptionHandler(SaldoInsuficienteException.class)
    protected ResponseEntity<String> handleSaldoInsulficiente(SaldoInsuficienteException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getMessage());
    }

    @ExceptionHandler(ErroSenhaException.class)
    protected ResponseEntity<String> handleErroSenha(ErroSenhaException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ex.getMessage());
    }

}
