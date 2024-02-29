package com.coder.ecommerce.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla factura relacionada con la tabla cliente
@Entity
@Getter
@Setter
@Table(name="facturas")

public class Factura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id usuario autogestionado por la Base de Datos",requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name="idCliente")
    @Schema(description = "Cliente perteneciente a la factura",requiredMode = Schema.RequiredMode.REQUIRED)
    private Cliente cliente;

    @Column(name="FECHA_FACTURA")
    @Schema(description = "Fecha de realización de la factura",requiredMode = Schema.RequiredMode.REQUIRED, example = "12/01/2024T12:00Z")
    private Date fecha;

    @Column(name = "VALOR_TOTAL_FACTURA")
    @Schema(description = "Valor total facturado en la factura",requiredMode = Schema.RequiredMode.REQUIRED, example = "999.88")
    private Double total;

    @Column (name = "CANTIDAD_TOTAL_PRODUCTOS")
    @Schema(description = "Cantidad de productos vendidos",requiredMode = Schema.RequiredMode.REQUIRED, example = "4")
    private int cantidadTotalProductosVendidos;

    @OneToMany(mappedBy = "factura", fetch=FetchType.EAGER,  cascade = CascadeType.ALL)
    @Schema(description = "Listado de productos facturados",requiredMode = Schema.RequiredMode.REQUIRED)
    private List<DetalleFactura> detalleFactura;

    public Factura(){}

    public Factura (Cliente clienteN, Double totalPesos){
        this.cliente = clienteN;
        this.total = totalPesos;
        this.fecha = new Date();
    }


}
