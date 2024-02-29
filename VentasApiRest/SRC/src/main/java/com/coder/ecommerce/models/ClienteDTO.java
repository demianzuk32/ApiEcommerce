package com.coder.ecommerce.models;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

//Establezco Entidad para la tabla Clientes

@Getter
@Setter
public class ClienteDTO {
    @Schema(description = "Nombre del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Demian")
    private String nombre;

    @Schema(description = "Apellido del Cliente",requiredMode = Schema.RequiredMode.REQUIRED, example = "Zuk")
    private String apellido;


    @Schema(description = "Número de documento del Cliente", requiredMode = Schema.RequiredMode.REQUIRED,example = "44362879")
    private String dni;

    public ClienteDTO(){}
    public ClienteDTO(String nom, String apel, String dni){
        this.nombre = nom;
        this.apellido = apel;
        this.dni = dni;
    }

}
