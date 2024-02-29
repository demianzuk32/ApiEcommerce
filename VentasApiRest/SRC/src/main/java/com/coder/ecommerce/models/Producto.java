package com.coder.ecommerce.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

//Establezco Entidad para la tabla productos relacionada con la tabla detalleFactura
@Entity
@Getter
@Setter
@Table(name="productos")
public class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true,description = "id usuario autogestionado por la Base de Datos",requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long idProducto;

    @Column (name = "DESCRIPCION_PRODUCTO")
    @Schema(description = "Descripcion del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "Televisor 29")
    private String descripcion;

    @Column (name = "CODIGO_PRODUCTO")
    @Schema(description = "Codigo del Producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "7798844787")
    private String codigo;

    @Column(name = "STOCK_PRODUCTO")
    @Schema(description = "Stock vigente del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "85")
    private int stock;

    @Column (name = "PRECIO_PRODUCTO")
    @Schema(description = "Valor del producto",requiredMode = Schema.RequiredMode.REQUIRED, example = "110.85")
    private Double precio;


    public Producto(){}
    public Producto (String descripcionS, String codigoS, int stockI, Double precioD ){
        this.descripcion = descripcionS;
        this.codigo = codigoS;
        this.stock = stockI;
        this.precio = precioD;
    }


}
