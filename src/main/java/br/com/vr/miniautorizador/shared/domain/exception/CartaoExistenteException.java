package br.com.vr.miniautorizador.shared.domain.exception;

public class CartaoExistenteException extends RuntimeException {

    public CartaoExistenteException() {
    }

    public CartaoExistenteException(String message) {
        super(message);
    }

    public CartaoExistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartaoExistenteException(Throwable cause) {
        super(cause);
    }

}
