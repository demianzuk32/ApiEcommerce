package com.coder.ecommerce.service;

import com.coder.ecommerce.models.Cliente;
import com.coder.ecommerce.models.ClienteDTO;
import com.coder.ecommerce.repository.RepositoryCliente;
import com.coder.ecommerce.repository.RepositoryFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Aqui se aplican toda la logica de Negocio de Clientes


@Service
public class ClienteService {
    @Autowired
    private RepositoryCliente repositorio;

    @Autowired
    private RepositoryFactura repositoryFactura;

    public List<ClienteDTO> listar (){
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        for (Cliente cliente:this.repositorio.findAll()){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNombre(cliente.getNombre());
            clienteDTO.setDni(cliente.getDni());
            clienteDTO.setApellido(cliente.getApellido());
            clienteDTOS.add(clienteDTO);
        }
        return clienteDTOS;
    }

    //Metodo de carga de datos en la base de datos, en la tabla Clientes
    public void inicializarClientes (){
        repositorio.save(new Cliente("Alejandro", "Baldres", "31552477"));
        repositorio.save(new Cliente("Hugo", "Basso","12478447"));
        repositorio.save(new Cliente("Raquel", "Garcia", "25784787"));
    }


    public ResponseEntity<String> grabar(Cliente cliente){
        if (cliente.getNombre() == null || cliente.getApellido() == null ||
                cliente.getDni() == null)    {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        } else
        {
            try {
                this.repositorio.save(cliente);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } catch (Exception e) {
                return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
            }
        }
    }

    public ResponseEntity<String> actualizar(Long id, ClienteDTO cliente){
        try {
            Optional<Cliente> resultadoBBDD = this.repositorio.findById(id);
            if (resultadoBBDD.isPresent()) {
                Cliente updateCliente = resultadoBBDD.get();
                updateCliente.setNombre(cliente.getNombre());
                updateCliente.setApellido(cliente.getApellido());
                updateCliente.setDni(cliente.getDni());
                this.repositorio.save(updateCliente);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } else {
                return ResponseEntity.status(409).body("Error Code: 409\nID #" + id +" No hallado en la BBDD");
            }
        } catch (Exception e) {
        return ResponseEntity.status(409).body("Error Code: 409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }

    public ResponseEntity<String> borrar(Long id){
        try{
            Optional<Cliente> resultadoBBDD = this.repositorio.findById(id);
            if (resultadoBBDD.isPresent()) {
                Cliente deleteCliente = resultadoBBDD.get();
                this.repositorio.delete(deleteCliente);
                return ResponseEntity.status(200).body("200 -> Operacion Satisfactoria!\n");
            } else {
                return ResponseEntity.status(409).body("Error Code: 409\nNo existe Cliente con ID #" + id + " en la BBDD");
            }
        } catch (Exception e) {
            return ResponseEntity.status(409).body("409 -> La operacion no se pudo realizar, verificar!\n");
        }
    }


}
