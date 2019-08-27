package br.com.hoffmann.fabricante.domain.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class DeleteFabricanteResponse implements Serializable {

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
        if (!(o instanceof DeleteFabricanteResponse)) return false;
        DeleteFabricanteResponse that = (DeleteFabricanteResponse) o;
        return Objects.equals(getMensagem(), that.getMensagem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMensagem());
    }
}
