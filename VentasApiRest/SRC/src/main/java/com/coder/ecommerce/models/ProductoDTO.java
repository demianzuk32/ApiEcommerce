package com.coder.ecommerce.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {

    @Schema(description = "Descripcion del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "Monitor")
    private String descripcion;
    @Schema(description = "Codigo del Producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "888543883")
    private String codigo;
}
