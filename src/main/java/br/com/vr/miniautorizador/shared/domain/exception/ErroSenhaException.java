package br.com.vr.miniautorizador.shared.domain.exception;

public class ErroSenhaException extends RuntimeException {

    public ErroSenhaException() {
    }

    public ErroSenhaException(String message) {
        super(message);
    }

    public ErroSenhaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErroSenhaException(Throwable cause) {
        super(cause);
    }
}
