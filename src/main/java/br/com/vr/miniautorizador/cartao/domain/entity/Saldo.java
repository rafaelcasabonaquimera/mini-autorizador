package br.com.vr.miniautorizador.cartao.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Saldo {

    private BigDecimal saldo;

}
