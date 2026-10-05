package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.ServicioDTO;
import com.upc.webcomparasalud.entidades.Servicio;
import com.upc.webcomparasalud.servicios.ServicioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ServicioController {
    @Autowired
    private ServicioServicio servicioServicio;

    @PostMapping("/servicio")
    @PreAuthorize("hasRole('ADMIN')")
    public ServicioDTO insertar(@RequestBody ServicioDTO servicioDTO){
        return servicioServicio.insertar(servicioDTO);
    }

    @GetMapping("/servicios")
    @PreAuthorize("permitAll()")
    public List<ServicioDTO> listar(){
        log.info("Iniciando lista de servicios");
        return  servicioServicio.listar();
    }

    @PutMapping("/servicio")
    @PreAuthorize("hasRole('ADMIN')")
    public Servicio editar(@RequestBody Servicio servicio){
        return servicioServicio.editar(servicio);
    }

    @DeleteMapping("/servicio/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        servicioServicio.eliminar(id);
    }

    @GetMapping("/servicios/buscar/{medicamento}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public List<ServicioDTO> buscarPorMedicamento(@PathVariable String medicamento) {
        log.info("Buscando servicios por medicamento");
        return servicioServicio.buscarServiciosPorNombreMedicamento(medicamento);
    }

    @GetMapping("/servicios/centro/{idCentro}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public List<ServicioDTO> listarPorCentro(@PathVariable Long idCentro) {
        log.info("Buscando servicios por centro");
        return servicioServicio.listarPorCentro(idCentro);
    }
}
