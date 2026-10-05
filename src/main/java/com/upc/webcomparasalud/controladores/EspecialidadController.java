package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.EspecialidadDTO;
import com.upc.webcomparasalud.entidades.Especialidad;
import com.upc.webcomparasalud.servicios.EspecialidadServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class EspecialidadController {
    @Autowired
    private EspecialidadServicio especialidadServicio;

    @PostMapping("/especialidad")
    @PreAuthorize("hasRole('ADMIN')")
    public EspecialidadDTO insertar(@RequestBody EspecialidadDTO especialidadDTO){
        return  especialidadServicio.insertar(especialidadDTO);
    }

    @GetMapping("/especialidades")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EspecialidadDTO> listar(){
        log.info("Iniciando lista de especialidades");
        return especialidadServicio.listar();
    }

    @PutMapping("/especialidad")
    @PreAuthorize("hasRole('ADMIN')")
    public Especialidad editar(@RequestBody Especialidad especialidad){
        return especialidadServicio.editar(especialidad);
    }

    @DeleteMapping("/especialidad/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        especialidadServicio.eliminar(id);
    }
}
