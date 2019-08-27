package br.com.hoffmann.fabricante.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class CreateFabricanteResponse implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "Mensagem")
    private String mensagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateFabricanteResponse)) return false;
        CreateFabricanteResponse response = (CreateFabricanteResponse) o;
        return Objects.equals(getId(), response.getId()) &&
                Objects.equals(getMensagem(), response.getMensagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMensagem());
    }
}