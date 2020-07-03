package br.com.hoffmann.fornecedor.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class FornecedorRequest implements Serializable {

    @ApiModelProperty(value = "Nome")
    @NotNull
    @Size(min = 1, max = 50, message = "NOME deve estar entre 1 a 50 caracteres")
    private String nome;

    @ApiModelProperty(value = "Descricao")
    @NotNull
    @Size(min = 1, max = 50, message = "DESCRICAO deve estar entre 1 a 50 caracteres")
    private String descricao;

    @ApiModelProperty(value = "Cnpj")
    @NotNull
    @CNPJ
    @Size(min = 1, max = 18, message = "CNPJ deve estar entre 1 e 18 caracteres")
    private String cnpj;

    @ApiModelProperty(value = "Estado")
    @NotNull
    @Size(min = 1, max = 30, message = "ESTADO deve estar entre 1 e 30 caracteres")
    private String estado;

    @ApiModelProperty(value = "Sigla")
    @NotNull
    @Size(min = 2, max = 2, message = "SIGLA deve ter 2 caracteres")
    private String sigla;

    @ApiModelProperty(value = "Cidade")
    @NotNull
    @Size(min = 1, max = 50, message = "CIDADE deve estar entre 1 e 50 caracteres")
    private String cidade;

    @ApiModelProperty(value = "Rua")
    @NotNull
    @Size(min = 1, max = 100, message = "RUA deve estar entre 1 e 100 caracteres")
    private String rua;

    @ApiModelProperty(value = "Numero")
    @NotNull
    private int numero;

    @ApiModelProperty(value = "Bairro")
    @NotNull
    @Size(min = 1, max = 30, message = "BAIRRO deve estar entre 1 e 30 caracteres")
    private String bairro;

    @ApiModelProperty(value = "Cep")
    @NotNull
    @Size(min = 1, max = 10, message = "CEP deve estar entre 1 e 10 caracteres")
    private String cep;

    @ApiModelProperty(value = "Complemento")
    @Size(max = 20, message = "complemento Maximo é de 20 caracteres")
    private String complemento;

    @ApiModelProperty(value = "Telefone")
    @NotNull
    @Size(min = 1, max = 10, message = "TELEFONE deve estar entre 1 e 10 caracteres")
    private String telefone;

    @ApiModelProperty(value = "Celular")
    @NotNull
    @Size(min = 1, max = 11, message = "CELULAR deve estar entre 1 e 11 caracteres")
    private String celular;

    @ApiModelProperty(value = "Email")
    @NotNull
    @Size(min = 1, max = 100, message = "EMAIL deve estar entre 1 e 100 caracteres")
    private String email;

    public interface createRequest {
    }

    public interface updateRequest {
    }
}
