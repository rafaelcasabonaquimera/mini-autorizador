package br.com.vr.miniautorizador.shared.domain.exception;

import br.com.vr.miniautorizador.transacao.domain.entity.Transacao;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
    }

    public SaldoInsuficienteException(String message) {
        super(message);
    }

    public SaldoInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaldoInsuficienteException(Throwable cause) {
        super(cause);
    }
}
