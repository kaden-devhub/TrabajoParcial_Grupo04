package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.ClienteDTO;
import com.upc.webcomparasalud.entidades.Cliente;
import com.upc.webcomparasalud.repositorios.ClienteRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ClienteDTO insertar(ClienteDTO clienteDTO){
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        Cliente clienteGrabado = clienteRepositorio.save(cliente);
        return modelMapper.map(clienteGrabado, ClienteDTO.class);
    }

    public List<ClienteDTO> listar(){
        return clienteRepositorio.findAll().stream().
                map(cliente -> modelMapper.
                        map(cliente, ClienteDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Cliente editar(Cliente cliente) {
        if (clienteRepositorio.existsById(cliente.getId()))
            return clienteRepositorio.save(cliente);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!clienteRepositorio.existsById(id))
            throw new RuntimeException ("No existe el cliente con el id: " + id);
        clienteRepositorio.deleteById(id);
    }
}
