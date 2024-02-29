package com.coder.ecommerce.models;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class FacturaDTO {
    @Schema(description = "id usuario autogestionado por la Base de Datos",requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;
    @Schema(description = "Cliente perteneciente a la factura",requiredMode = Schema.RequiredMode.REQUIRED)
    private ClienteDTO cliente;
    @Schema(description = "Fecha de realización de la factura",requiredMode = Schema.RequiredMode.REQUIRED, example = "12/01/2024T12:00Z")
    private Date fecha;
    @Schema(description = "Valor total facturado en la factura",requiredMode = Schema.RequiredMode.REQUIRED, example = "999.88")
    private Double total;
    @Schema(description = "Listado de productos facturados",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DetalleFacturaDTO> detalleFactura;
    @Schema(description = "Cantidad de productos vendidos",requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private int cantidadTotalProductosVendidos;

    public FacturaDTO(){}

}
