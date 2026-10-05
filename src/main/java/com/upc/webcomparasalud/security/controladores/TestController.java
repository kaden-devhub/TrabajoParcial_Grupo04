package com.upc.webcomparasalud.security.controladores;


import com.upc.webcomparasalud.security.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "${ip.frontend}", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RestController
@RequestMapping("/api")
public class TestController {


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminEndpoint() {
        return "Este es el punto de acceso para el usuario de rol ADMIN, solo accesible a ADMIN";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('CLIENTE', 'PROVEEDOR', 'ADMIN')")
    public String usuarioEndpoint() {
        return"Este es el punto de acceso para el usuario de rol ADMIN, PROVEEDOR o CLIENTE, solo accesible con estos roles";
    }

}
