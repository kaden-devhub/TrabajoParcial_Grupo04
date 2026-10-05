package com.upc.webcomparasalud.controladores;

import com.upc.webcomparasalud.dto.ClienteDTO;
import com.upc.webcomparasalud.entidades.Cliente;
import com.upc.webcomparasalud.servicios.ClienteServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ClienteController {
    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/cliente")
    public ClienteDTO insertar(@RequestBody ClienteDTO clienteDTO){
        return clienteServicio.insertar(clienteDTO);
    }

    @GetMapping("/clientes")
    public List<ClienteDTO> listar(){
        log.info("Iniciando lista de clientes");
        return clienteServicio.listar();
    }

    @GetMapping("/cliente")
    public Cliente editar(@RequestBody Cliente  cliente){
        return clienteServicio.editar(cliente);
    }

    @PutMapping("/cliente/{id}")
    public void eliminar(@PathVariable Long id){
        clienteServicio.eliminar(id);
    }
}
