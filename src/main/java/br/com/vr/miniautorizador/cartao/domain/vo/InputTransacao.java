package br.com.vr.miniautorizador.cartao.domain.vo;

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

    private Integer senhaCartao;

    private BigDecimal valor;

}
