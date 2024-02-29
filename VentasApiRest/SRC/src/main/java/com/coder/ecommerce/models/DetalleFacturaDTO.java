package com.coder.ecommerce.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalleFacturaDTO {
    @Schema(description = "Cantidad del Producto facturado",requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private int cantidad;
    @Schema(description = "Producto facturado",requiredMode = Schema.RequiredMode.REQUIRED)
    private ProductoDTO producto;
    @Schema(description = "Precio del producto facturado",requiredMode = Schema.RequiredMode.REQUIRED, example = "150.55")
    private Double precioProducto;

}
