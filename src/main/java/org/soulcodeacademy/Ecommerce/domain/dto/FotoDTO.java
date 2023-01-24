package org.soulcodeacademy.Ecommerce.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FotoDTO {

    @NotBlank(message = "URL de foto nao pode ser nulo")
    private String url;

    @NotNull(message ="o idProduto nao pode ser nulo")
    private Integer idProduto;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }
}
