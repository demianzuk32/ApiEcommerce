package com.coder.ecommerce.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//Establezco Entidad para la tabla detallefactura relacionada con tablas facturas y productos
@Entity
@Getter
@Setter
@Table(name="detallefactura")

public class DetalleFactura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Schema(description = "id usuario autogestionado por la Base de Datos",requiredMode = Schema.RequiredMode.AUTO, example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "CANTIDAD_PRODUCTO")
    @Schema(description = "Cantidad del Producto vendido",requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="idProducto")
    @Schema(description = "Producto",requiredMode = Schema.RequiredMode.REQUIRED)
    private Producto Producto;

    @Column (name = "PRECIO_PRODUCTO")
    @Schema(description = "Precio del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "100.58")
    private Double precioProducto;

    @ManyToOne
    @JoinColumn(name = "FK_FACTURA", nullable = false, updatable = false)
    @Schema(hidden = true)
    private Factura factura;

    public DetalleFactura(){}
    public DetalleFactura(int cantidadP, Double subtotalF, Factura f) {
        this.cantidad = cantidadP;
        this.precioProducto = subtotalF;
        this.factura = f;
    }
}
