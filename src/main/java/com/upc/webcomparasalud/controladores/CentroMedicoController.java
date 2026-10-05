package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.CentroMedicoDTO;
import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.servicios.CentroMedicoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CentroMedicoController {
    @Autowired
    private CentroMedicoServicio centroMedicoServicio;

    @PostMapping("/centro-medico")
    @PreAuthorize("hasRole('ADMIN')")
    public CentroMedicoDTO insertar(@RequestBody CentroMedicoDTO centroMedicoDTO) {
        return centroMedicoServicio.insertar(centroMedicoDTO);
    }

    @GetMapping("/centros-medicos")
    @PreAuthorize("permitAll()")
    public List<CentroMedicoDTO> listar() {
        log.info("Iniciando lista de centros-medicos");
        return centroMedicoServicio.listar();
    }

    @PutMapping("/centro-medico")
    @PreAuthorize("hasRole('ADMIN')")
    public CentroMedico editar(@RequestBody CentroMedico centroMedico) {
        return centroMedicoServicio.editar(centroMedico);
    }

    @DeleteMapping("/centro-medico/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id) {
        centroMedicoServicio.eliminar(id);
    }

    @GetMapping("/centros-medicos/buscar/{filtro}")
    @PreAuthorize("hasRole('CLIENTE')")
    public List<CentroMedicoDTO> buscar(@PathVariable String filtro) {
        return centroMedicoServicio.buscarPorNombreDistrito(filtro);
    }
}
