package br.com.vr.miniautorizador.shared.domain.exception;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;

public class CartaoExistenteException extends RuntimeException {

    private Cartao cartao;

    public CartaoExistenteException() {
    }

    public CartaoExistenteException(String message, final Cartao cartao) {
        super(message);
        this.cartao = cartao;
    }

    public CartaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartaoExistenteException(Throwable cause) {
        super(cause);
    }

    public Cartao getCartao() {
        return cartao;
    }
}
