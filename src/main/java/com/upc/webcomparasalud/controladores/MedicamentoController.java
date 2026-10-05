package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.entidades.Medicamento;
import com.upc.webcomparasalud.servicios.MedicamentoServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MedicamentoController {
    @Autowired
    private MedicamentoServicio medicamentoServicio;

    @PostMapping("/medicamento")
    @PreAuthorize("hasAnyRole('PROVEEDOR','ADMIN')")
    public MedicamentoDTO insertar(@RequestBody MedicamentoDTO medicamentoDTO){
        return medicamentoServicio.insertar(medicamentoDTO);
    }

    @GetMapping("/medicamentos")
    @PreAuthorize("permitAll()")
    public List<MedicamentoDTO> listar(){
        log.info("Iniciando lista de medicamentos");
        return medicamentoServicio.listar();
    }

    @PutMapping("/medicamento")
    @PreAuthorize("hasAnyRole('PROVEEDOR','ADMIN')")
    public Medicamento editar(@RequestBody Medicamento medicamento){
        return medicamentoServicio.editar(medicamento);
    }

    @DeleteMapping("/medicamento/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminar(@PathVariable Long id){
        medicamentoServicio.eliminar(id);
    }


    @GetMapping("/medicamentos/filtrar/Categoria/{categoria}/Precio/{precioMin}/{precioMax}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public List<MedicamentoDTO> filtrarPorCategoriaYPrecio(@PathVariable String categoria,
                                                           @PathVariable double precioMin,
                                                           @PathVariable double precioMax) {
        return medicamentoServicio.filtrarPorCategoriaYPrecio(categoria, precioMin, precioMax);
    }

    @GetMapping("/medicamentos/alternativas/Centro/{idCentroMed}/{principioActivo}/{idMedicamentoActual}")
    @PreAuthorize("hasAnyRole('CLIENTE')")
    public List<MedicamentoDTO> filtrarOpciones(@PathVariable String principioActivo,
                                                @PathVariable Long idCentroMed,
                                                @PathVariable Long idMedicamentoActual) {
        return medicamentoServicio.filtrarOpciones(principioActivo, idCentroMed, idMedicamentoActual);
    }


}






