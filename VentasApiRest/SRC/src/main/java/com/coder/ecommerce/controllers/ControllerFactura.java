package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Factura;
import com.coder.ecommerce.models.FacturaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import com.coder.ecommerce.service.FacturaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping(path = "api/facturas")
public class ControllerFactura {
    @Autowired
    private FacturaService facturaServicio;


    @Operation(summary = "Lista los comprobantes realizados", description = "Retorna un JSON con las comprobantes realizadas")
    @GetMapping("listar")
    public List<FacturaDTO> getFactura(){
        return this.facturaServicio.listar();
    }

    @Operation(summary = "Agrega una factura", description = "Agrega una factura a la Base de Datos")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion Exitosa, factura agregada"),
            @ApiResponse(responseCode = "409", description = "Error Code: 409 No se puede vender {##} unidades, por que " +
                    "supera el stock disponible de {unidades} unidades / No existe Producto con ID #{id} / No existe Cliente con ID #{ID}" +
                    " / La operacion no pudo completarse",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FacturaDTO.class))})})
    @PostMapping("agregar")
    public ResponseEntity<String> agregar(@RequestBody Factura factura){

       return this.facturaServicio.agregar(factura);
    }

    @Operation(summary = "Eliminacion de venta", description = "Elimina una venta de la Base")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
        return this.facturaServicio.borrar(id);
    }
}
