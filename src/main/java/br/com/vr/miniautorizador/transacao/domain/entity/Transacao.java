package br.com.vr.miniautorizador.transacao.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Transacao {

    private String numeroCartao;
    private String senhaCartao;
    private BigDecimal valor;

}
