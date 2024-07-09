package br.com.vr.miniautorizador.cartao.domain.specification;

import br.com.vr.miniautorizador.cartao.domain.entity.Cartao;
import br.com.vr.miniautorizador.shared.domain.specification.AbstractSpecification;
import br.com.vr.miniautorizador.shared.domain.specification.Specifications;

public interface CartaoSpecification {

    static AbstractSpecification<Cartao> numeroCartaoIsNotEmtpy() {
        return Specifications.basic("O numero do cartão deve ser informado",
                (candidate, v) -> candidate.getNumeroCartao() != null && !candidate.getNumeroCartao().isEmpty());
    }

}
