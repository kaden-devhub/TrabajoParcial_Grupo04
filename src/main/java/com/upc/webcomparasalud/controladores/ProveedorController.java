package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.ProveedorDTO;
import com.upc.webcomparasalud.entidades.Proveedor;
import com.upc.webcomparasalud.servicios.ProveedorServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private ProveedorServicio proveedorServicio;
    @PostMapping("/proveedor")
    public ProveedorDTO insertar(@RequestBody ProveedorDTO proveedorDTO) {
        return proveedorServicio.insertar(proveedorDTO);
    }

    @GetMapping("/proveedores")
    public List<ProveedorDTO> listar(){
        log.info("Iniciando lista de proveedores");
        return proveedorServicio.listar();
    }

    @PutMapping("/proveedor")
    public Proveedor editar(@RequestBody Proveedor proveedor){
        return proveedorServicio.editar(proveedor);
    }

    @DeleteMapping("/proveedor/{id}")
    public void eliminar (@PathVariable Long id){
        proveedorServicio.eliminar(id);
    }
}
