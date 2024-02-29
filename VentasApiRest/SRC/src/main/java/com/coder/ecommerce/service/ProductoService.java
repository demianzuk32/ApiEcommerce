package com.coder.ecommerce.service;

import com.coder.ecommerce.models.Producto;
import com.coder.ecommerce.models.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.coder.ecommerce.repository.RepositoryProducto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Aqui se aplican toda la logica de Negocio de los Productos
@Service
public class ProductoService {
    @Autowired
    private RepositoryProducto repositorio;

    public List<ProductoDTO> listar(){
        List<ProductoDTO> productosDTO = new ArrayList<>();

        for (Producto producto:repositorio.findAll()){
            ProductoDTO dtoProducto = new ProductoDTO();
            dtoProducto.setCodigo(producto.getCodigo());
            dtoProducto.setDescripcion(producto.getDescripcion());
            productosDTO.add(dtoProducto);
        }
        return productosDTO;
    }



    public ResponseEntity<String> grabar(Producto producto){
        if (producto.getDescripcion() == null || producto.getCodigo() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(producto);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    public ResponseEntity<String> actualizar(Long id, Producto producto){
        try {
            Optional<Producto> produtoEnBBDD = this.repositorio.findById(id);
            if (produtoEnBBDD.isPresent()) {
                Producto updateProducto = produtoEnBBDD.get();
                updateProducto.setDescripcion(producto.getDescripcion());
                updateProducto.setCodigo(producto.getCodigo());
                updateProducto.setStock(producto.getStock());
                updateProducto.setPrecio(producto.getPrecio());
                this.repositorio.save(updateProducto);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } else {
                return ResponseEntity.status(409).body("Error Code: 409\nProducto ID #" + id + " no hallado en BBDD");
            }
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> borrar (Long id){
        try {
            Optional<Producto> productoEnBBDD = this.repositorio.findById(id);
            if (productoEnBBDD.isPresent()) {
                Producto deleteProducto = productoEnBBDD.get();
                this.repositorio.delete(deleteProducto);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } else {
                return ResponseEntity.status(409).body("Error Code: 409\nProducto ID #" + id + " no hallado en BBDD");
            }
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> actualizarStock (Long id, int unidadesVendidas){
        try {
                Optional<Producto> productoEnBBDD = this.repositorio.findById(id);
                if (productoEnBBDD.isPresent()) {
                    Producto updateProducto = productoEnBBDD.get();
                    updateProducto.setStock(updateProducto.getStock() - unidadesVendidas);
                    this.repositorio.save(updateProducto);
                    return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
                } else {
                    return ResponseEntity.status(409).body("Error Code: 409\nProducto ID #" + id + " no hallado en BBDD");
                }
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }
}
