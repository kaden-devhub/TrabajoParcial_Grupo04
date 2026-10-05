package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.MedicoDTO;
import com.upc.webcomparasalud.entidades.Medico;
import com.upc.webcomparasalud.servicios.MedicoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MedicoController {
    @Autowired
    private MedicoServicio medicoServicio;

    @PostMapping("/medico")
    @PreAuthorize("hasRole('ADMIN')")
    public MedicoDTO insertar(@RequestBody MedicoDTO medicoDTO){
        return medicoServicio.insertar(medicoDTO);
    }

    @GetMapping("/medicos")
    @PreAuthorize("permitAll()")
    public List<MedicoDTO> listar(){
        log.info("Iniciando lista de medicos");
        return medicoServicio.listar();
    }

    @PutMapping("/medico")
    @PreAuthorize("hasRole('ADMIN')")
    public Medico editar(@RequestBody Medico medico){
        return medicoServicio.editar(medico);
    }

    @DeleteMapping("/medico/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        medicoServicio.eliminar(id);
    }

    @GetMapping("/medicos/especialidad/{idEspecialidad}/centro/{idCentroMed}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public List<MedicoDTO> filtrarMedicosPorEspecialidadYCentro(@PathVariable Long idEspecialidad, @PathVariable Long idCentroMed) {
        return medicoServicio.filtrarMedicosPorEspecialidadYCentro(idEspecialidad, idCentroMed);
    }

}
