package br.com.vr.miniautorizador.cartao.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Cartao {

    private String numeroCartao;

    private String senha;

    @JsonIgnore
    private BigDecimal saldo;

}
