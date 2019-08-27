package br.com.hoffmann.fabricante.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class UpdateFabricanteResponse implements Serializable {

    @ApiModelProperty(value = "Mensagem")
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UpdateFabricanteResponse)) return false;
        UpdateFabricanteResponse that = (UpdateFabricanteResponse) o;
        return Objects.equals(getMensagem(), that.getMensagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMensagem());
    }
}

