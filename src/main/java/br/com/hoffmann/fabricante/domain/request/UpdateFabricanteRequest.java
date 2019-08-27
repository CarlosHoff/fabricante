package br.com.hoffmann.fabricante.domain.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class UpdateFabricanteRequest implements Serializable {

    @ApiModelProperty(value = "Nome")
    @Size(max = 50, message = "NOME maximo de 50 caracteres")
    private String nome;

    @ApiModelProperty(value = "Descricao")
    @Size(max = 50, message = "DESCRICAO maxima de 50 caracteres")
    private String descricao;

    @ApiModelProperty(value = "Cnpj")
    @Size(max = 18, message = "CNPJ maximo de 18 caracteres")
    private String cnpj;

    @ApiModelProperty(value = "Estado")
    @Size(max = 30, message = "ESTADO maximo de 30 caracteres")
    private String estado;

    @ApiModelProperty(value = "Sigla")
    @Size(max = 2, message = "SIGLA maxima de 2 caracteres")
    private String sigla;

    @ApiModelProperty(value = "Cidade")
    @Size(max = 50, message = "CIDADE maximo de 50 caracteres")
    private String cidade;

    @ApiModelProperty(value = "Rua")
    @Size(max = 100, message = "RUA maxima de 100 caracteres")
    private String rua;

    @ApiModelProperty(value = "Numero")
    private int numero;

    @ApiModelProperty(value = "Bairro")
    @Size(max = 30, message = "BAIRRO maximo de 30 caracteres")
    private String bairro;

    @ApiModelProperty(value = "Cep")
    @Size(max = 10, message = "CEP maximo de 10 caracteres")
    private String cep;

    @ApiModelProperty(value = "Complemento")
    @Size(max = 20, message = "COMPLEMENTO maximo de 20 caracteres")
    private String complemento;

    @ApiModelProperty(value = "Telefone")
    @Size(max = 10, message = "TELEFONE maximo de 10 caracteres")
    private String telefone;

    @ApiModelProperty(value = "Celular")
    @Size(max = 11, message = "CELULAR maximo de 11 caracteres")
    private String celular;

    @ApiModelProperty(value = "Email")
    @Size(max = 100, message = "EMAIL maximo de 100 caracteres")
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
        if (!(o instanceof UpdateFabricanteRequest)) return false;
        UpdateFabricanteRequest that = (UpdateFabricanteRequest) o;
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