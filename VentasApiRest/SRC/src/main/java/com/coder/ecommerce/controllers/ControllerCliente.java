package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Cliente;
import com.coder.ecommerce.models.ClienteDTO;
import com.coder.ecommerce.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/clientes")
@Tag(name = "Clientes", description = "Administracion de Clientes")
public class ControllerCliente {
    @Autowired
    private ClienteService servicioCliente;

    @Operation (summary = "Lista Clientes", description = "Lista de todos los clientes")
    @GetMapping("listar")
    public List<ClienteDTO> getCliente(){
        return this.servicioCliente.listar();
    }


    @Operation (summary = "Agrega un Cliente", description = "Agrega un cliente a la Base de Datos",requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    schema=@Schema(implementation = ClienteDTO.class))))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion exitosa, cliente agregado"),
        @ApiResponse(responseCode = "409", description = "La operacion no se pudo completar. No se pudo crear " +
                "el registro en la Base",content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = ClienteDTO.class))})})

    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody Cliente cliente){

        return (this.servicioCliente.grabar(cliente));
    }

    @Operation(summary = "Modifica un cliente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion exitosa, cliente modificado"),
            @ApiResponse(responseCode = "409", description = "Error Code: 409 ID #{id} No hallado en la Base de Datos. La operacion no se pudo realizar",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteDTO.class))})})
    @PutMapping("modificar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody ClienteDTO cliente){
       return(this.servicioCliente.actualizar(id,cliente));
    }

    @Operation (summary = "Elimina un Cliente Existente", description = "Elimina cliente de la Base de Datos")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return(this.servicioCliente.borrar(id));
    }
}
