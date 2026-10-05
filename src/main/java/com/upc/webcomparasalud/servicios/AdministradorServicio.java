package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.AdministradorDTO;
import com.upc.webcomparasalud.entidades.Administrador;
import com.upc.webcomparasalud.repositorios.AdministradorRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServicio {
    @Autowired
    private AdministradorRepositorio administradorRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public AdministradorDTO insertar(AdministradorDTO administradorDTO) {
        Administrador administrador = modelMapper.map(administradorDTO, Administrador.class);
        Administrador administradorGrabado = administradorRepositorio.save(administrador);
        return modelMapper.map(administradorGrabado, AdministradorDTO.class);
    }

    public List<AdministradorDTO> listar(){
        return administradorRepositorio.findAll().stream().
                map(administrador -> modelMapper.
                        map(administrador, AdministradorDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Administrador editar(Administrador administrador) {
        if (administradorRepositorio.existsById(administrador.getId()))
            return administradorRepositorio.save(administrador);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!administradorRepositorio.existsById(id))
            throw new RuntimeException ("No existe el administrador con el id: " + id);
        administradorRepositorio.deleteById(id);
    }

}
