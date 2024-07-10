package br.com.vr.miniautorizador.transacao.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class InputTransacao {

    private String numeroCartao;

    private String senhaCartao;

    private BigDecimal valor;

}
