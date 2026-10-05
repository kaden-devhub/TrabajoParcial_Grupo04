package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.TipoServicioDTO;
import com.upc.webcomparasalud.entidades.TipoServicio;
import com.upc.webcomparasalud.servicios.TipoServicioServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class TipoServicioController {
    @Autowired
    private TipoServicioServicio tipoServicioServicio;

    @PostMapping("/tipo-servicio")
    @PreAuthorize("hasRole('ADMIN')")
    public TipoServicioDTO insertar(@RequestBody TipoServicioDTO tipoServicioDTO){
        return tipoServicioServicio.insertar(tipoServicioDTO);
    }

    @GetMapping("/tipos-servicios")
    @PreAuthorize("hasRole('ADMIN')")
    public List<TipoServicioDTO> listar(){
        log.info("Iniciando lista de tipos de servicio");
        return tipoServicioServicio.listar();
    }

    @PutMapping("/tipo-servicio")
    @PreAuthorize("hasRole('ADMIN')")
    public TipoServicio editar(@RequestBody TipoServicio tipoServicio){
        return tipoServicioServicio.editar(tipoServicio);
    }

    @DeleteMapping("/tipo-servicio/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        tipoServicioServicio.eliminar(id);
    }
}
