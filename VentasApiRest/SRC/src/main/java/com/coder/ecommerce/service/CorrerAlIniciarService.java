package com.coder.ecommerce.service;

import com.coder.ecommerce.config.ConfigSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


//Se utiliza la interface @EventListener para que se carguen los datos al iniciar SpringBoot
@Component
public class CorrerAlIniciarService {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FacturaService facturaService;
    @EventListener(ApplicationReadyEvent.class)
    public void correrAlIniciarService() {
        clienteService.inicializarClientes();
        facturaService.inicializarDatosFactura();
        ConfigSwagger s = new ConfigSwagger();
        s.customOpenAPI();

    }
}
