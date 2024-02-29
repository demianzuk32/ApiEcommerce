package com.coder.ecommerce.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

//Establezco Entidad para la tabla Clientes
@Entity
@Getter
@Setter
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id usuario autogestionado",requiredMode = Schema.RequiredMode.AUTO, example = "1")
    private Long idCliente;

    @Column (name = "NOMBRE_CLIENTE")
    @Schema(description = "Nombre del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Demian")
    private String nombre;

    @Column (name = "APELLIDO_CLIENTE")
    @Schema(description = "Apellido del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Zuk")
    private String apellido;

    @Column (name = "DNI_CLIENTE")
    @Schema(description = "Número de documento del Cliente", requiredMode = Schema.RequiredMode.REQUIRED,example = "44362879")
    private String dni;


    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Factura> facturas = new ArrayList<>();

    public Cliente(){}

    public Cliente(String nom, String apel, String dni){
        this.nombre = nom;
        this.apellido = apel;
        this.dni = dni;
    }
}
