package edu.infnet.br.petfrieds_almoxarifado.domain.model.valueobject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor @Getter
public class CodigoProduto {

    private String codigo;
    private static final Pattern PADRAO_CODIGO_VALIDO = Pattern.compile("^[A-Za-z0-9]{10}$");

    public CodigoProduto(String codigo) {
        if (!validarCodigo(codigo)){
            throw new IllegalArgumentException("Código de produto inválido");
        }
        this.codigo = codigo;
    }

    public boolean validarCodigo(String codigo) {
        return PADRAO_CODIGO_VALIDO.matcher(codigo).matches();
    }

}
