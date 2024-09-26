package edu.infnet.br.petfriends_transporte.domain.model.valueobject;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@NoArgsConstructor @Getter
public class Endereco {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    private static final Pattern PADRAO_CEP_VALIDO = Pattern.compile("^[0-9]{5}[-]?[0-9]{3}$");

    public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {
        if (!validarCep(cep)){
            throw new IllegalArgumentException("CEP inválido");
        }
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public boolean validarCep(String cep) {
        return PADRAO_CEP_VALIDO.matcher(cep).matches();
    }
}
