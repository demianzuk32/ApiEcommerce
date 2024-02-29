package com.coder.ecommerce.controllers;

import com.coder.ecommerce.models.Producto;
import com.coder.ecommerce.models.ProductoDTO;
import com.coder.ecommerce.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/productos")
public class ControllerProducto {
    @Autowired
    private ProductoService servicioProducto;

    @Operation(summary = "Lista productos", description = "Devuelve un JSON con todos productos")
    @GetMapping("listar")
    public List<ProductoDTO> listar(){
        return this.servicioProducto.listar();
    }

    @PostMapping("agregar")
    @Operation(summary = "Agrega un producto", description = "Agrega un producto a la Base")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion Exitosa, producto agregado"),
            @ApiResponse(responseCode = "409", description = "La operacion no pudo completarse",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))})})
    public ResponseEntity<String> agregar(@RequestBody Producto producto){
        return this.servicioProducto.grabar(producto);
    }

    @Operation(summary = "Modifica un producto", description = "Modifica un producto de la Base")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Operacion Exitosa, producto modificado"),
            @ApiResponse(responseCode = "409", description = "Error Code: 409 La operacion no pudo completarse",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))})})
    @PutMapping("modificar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Producto producto){
        return this.servicioProducto.actualizar(id,producto);
    }


    @Operation(summary = "Modifica Stock de un producto", description = "Modifica el stock de un producto de la Base")
    @PatchMapping("stock")
    public ResponseEntity<String> actualizarStock(@Validated @RequestParam(name = "id") Long id,@Validated @RequestParam(name = "ventas")  int ventas ){
        return this.servicioProducto.actualizarStock(id, ventas);
    }

    @Operation(summary = "Elimina un producto", description = "Elimina un producto de la Base")
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id){
       return this.servicioProducto.borrar(id);
    }
}
