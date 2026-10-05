package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.CentroMedClienteFavDTO;
import com.upc.webcomparasalud.servicios.CentroMedClienteFavServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CentroMedClienteFavController {
    @Autowired
    private CentroMedClienteFavServicio centroMedClienteFavServicio;

    @PostMapping("/centromedclientefav")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public CentroMedClienteFavDTO insertar(@RequestBody CentroMedClienteFavDTO centroMedClienteFavDTO) {
        return centroMedClienteFavServicio.insertar(centroMedClienteFavDTO);
    }

    @GetMapping("/centrosmedclientesfav")
    @PreAuthorize("hasAnyRole('CLIENTE', 'ADMIN')")
    public List<CentroMedClienteFavDTO> listar() {
        log.info("Iniciando lista de CentroMed y ClienteFav");
        return centroMedClienteFavServicio.listar();
    }
}
