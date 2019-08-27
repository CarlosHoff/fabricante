package br.com.hoffmann.fabricante.domain.request;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class CreateFabricanteRequest implements Serializable {

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateFabricanteRequest)) return false;
        CreateFabricanteRequest that = (CreateFabricanteRequest) o;
        return Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getCnpj(), that.getCnpj()) &&
                Objects.equals(getEstado(), that.getEstado()) &&
                Objects.equals(getSigla(), that.getSigla()) &&
                Objects.equals(getCidade(), that.getCidade()) &&
                Objects.equals(getRua(), that.getRua()) &&
                Objects.equals(getNumero(), that.getNumero()) &&
                Objects.equals(getBairro(), that.getBairro()) &&
                Objects.equals(getCep(), that.getCep()) &&
                Objects.equals(getComplemento(), that.getComplemento()) &&
                Objects.equals(getTelefone(), that.getTelefone()) &&
                Objects.equals(getCelular(), that.getCelular()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getDescricao(), getCnpj(), getEstado(), getSigla(), getCidade(), getRua(), getNumero(), getBairro(), getCep(), getComplemento(), getTelefone(), getCelular(), getEmail());
    }
}
