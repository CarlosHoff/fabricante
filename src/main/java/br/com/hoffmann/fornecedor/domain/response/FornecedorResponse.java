package br.com.hoffmann.fornecedor.domain.response;

import br.com.hoffmann.fornecedor.entity.Fornecedor;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class FornecedorResponse implements Serializable {

    @ApiModelProperty(value = "Fornecedor id")
    private Long fornecedorID;

    @ApiModelProperty(value = "Nome")
    private String nome;

    @ApiModelProperty(value = "Descricao")
    private String descricao;

    @ApiModelProperty(value = "Cnpj")
    private String cnpj;

    @ApiModelProperty(value = "Estado")
    private String estado;

    @ApiModelProperty(value = "Sigla")
    private String sigla;

    @ApiModelProperty(value = "Cidade")
    private String cidade;

    @ApiModelProperty(value = "Rua")
    private String rua;

    @ApiModelProperty(value = "Numero")
    private int numero;

    @ApiModelProperty(value = "Bairro")
    private String bairro;

    @ApiModelProperty(value = "Cep")
    private String cep;

    @ApiModelProperty(value = "Complemento")
    private String complemento;

    @ApiModelProperty(value = "Telefone")
    private String telefone;

    @ApiModelProperty(value = "Celular")
    private String celular;

    @ApiModelProperty(value = "Email")
    private String email;

    public FornecedorResponse(){

    }

    public FornecedorResponse(Fornecedor fornecedor) {
        this.fornecedorID = fornecedor.getFornecedorID();
        this.nome = fornecedor.getNome();
        this.descricao = fornecedor.getDescricao();
        this.cnpj = fornecedor.getCnpj();
        this.estado = fornecedor.getEstado();
        this.sigla = fornecedor.getSigla();
        this.cidade = fornecedor.getCidade();
        this.rua = fornecedor.getRua();
        this.numero = fornecedor.getNumero();
        this.bairro = fornecedor.getBairro();
        this.cep = fornecedor.getCep();
        this.complemento = fornecedor.getComplemento();
        this.telefone = fornecedor.getTelefone();
        this.celular = fornecedor.getCelular();
        this.email = fornecedor.getEmail();
    }
}
