package br.com.vr.miniautorizador.cartao.framework.output.persist.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("cartoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CartaoData {

    @Id
    private String id;
    private String numeroCartao;
    private Integer senha;

}
