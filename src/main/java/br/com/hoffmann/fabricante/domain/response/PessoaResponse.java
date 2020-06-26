package br.com.hoffmann.fabricante.domain.response;

import br.com.hoffmann.fabricante.domain.enums.TipoDeUsuario;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class PessoaResponse implements Serializable {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "Nome")
    private String nome;

    @ApiModelProperty(value = "CPF")
    private String cpf;

    @ApiModelProperty(value = "Tipo de usuario")
    private TipoDeUsuario tipoDeUsuario;

    @ApiModelProperty(value = "Status")
    private Character status;

    @ApiModelProperty(value = "Estado")
    private String estado;

    @ApiModelProperty(value = "Sigla")
    private String sigla;

    @ApiModelProperty(value = "Cidade")
    private String cidade;

    @ApiModelProperty(value = "Rua")
    private String rua;

    @ApiModelProperty(value = "Numero")
    private Short numero;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoDeUsuario getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(TipoDeUsuario tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
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
        if (!(o instanceof PessoaResponse)) return false;
        PessoaResponse response = (PessoaResponse) o;
        return Objects.equals(getId(), response.getId()) &&
                Objects.equals(getNome(), response.getNome()) &&
                Objects.equals(getCpf(), response.getCpf()) &&
                getTipoDeUsuario() == response.getTipoDeUsuario() &&
                Objects.equals(getStatus(), response.getStatus()) &&
                Objects.equals(getEstado(), response.getEstado()) &&
                Objects.equals(getSigla(), response.getSigla()) &&
                Objects.equals(getCidade(), response.getCidade()) &&
                Objects.equals(getRua(), response.getRua()) &&
                Objects.equals(getNumero(), response.getNumero()) &&
                Objects.equals(getBairro(), response.getBairro()) &&
                Objects.equals(getCep(), response.getCep()) &&
                Objects.equals(getComplemento(), response.getComplemento()) &&
                Objects.equals(getTelefone(), response.getTelefone()) &&
                Objects.equals(getCelular(), response.getCelular()) &&
                Objects.equals(getEmail(), response.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getCpf(), getTipoDeUsuario(), getStatus(), getEstado(), getSigla(), getCidade(), getRua(), getNumero(), getBairro(), getCep(), getComplemento(), getTelefone(), getCelular(), getEmail());
    }
}
