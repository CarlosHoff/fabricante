package br.com.hoffmann.fabricante.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class FindFabricanteResponse implements Serializable {

    @ApiModelProperty(value = "Fabricante id")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        if (!(o instanceof FindFabricanteResponse)) return false;
        FindFabricanteResponse that = (FindFabricanteResponse) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNome(), that.getNome()) &&
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
        return Objects.hash(getId(), getNome(), getDescricao(), getCnpj(), getEstado(), getSigla(), getCidade(), getRua(), getNumero(), getBairro(), getCep(), getComplemento(), getTelefone(), getCelular(), getEmail());
    }
}
