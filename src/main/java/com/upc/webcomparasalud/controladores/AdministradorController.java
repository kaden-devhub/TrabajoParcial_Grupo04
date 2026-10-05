package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.AdministradorDTO;
import com.upc.webcomparasalud.entidades.Administrador;
import com.upc.webcomparasalud.servicios.AdministradorServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class AdministradorController {
    @Autowired
    private AdministradorServicio administradorServicio;

    @PostMapping("/administrador")
    public AdministradorDTO insertar(@RequestBody AdministradorDTO administradorDTO) {
        return administradorServicio.insertar(administradorDTO);
    }

    @GetMapping("/administradores")
    public List<AdministradorDTO> listar() {
        log.info("Iniciando lista de administradores");
        return administradorServicio.listar();
    }

    @PutMapping("/administrador")
    public Administrador editar(@RequestBody Administrador administrador) {
        return administradorServicio.editar(administrador);
    }

    @DeleteMapping("/administrador/{id}")
    public void eliminar(@PathVariable Long id) {
        administradorServicio.eliminar(id);
    }
}
