package br.com.vr.miniautorizador.cartao.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cartao {

    private String numeroCartao;

    private Integer senha;

}
