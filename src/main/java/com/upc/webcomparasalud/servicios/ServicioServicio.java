package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.ServicioDTO;
import com.upc.webcomparasalud.entidades.Servicio;
import com.upc.webcomparasalud.repositorios.ServicioRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioServicio {
    @Autowired
    private ServicioRepositorio servicioRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ServicioDTO insertar(ServicioDTO servicioDTO) {
        Servicio servicio = modelMapper.map(servicioDTO, Servicio.class);
        Servicio servicioGrabado = servicioRepositorio.save(servicio);
        return modelMapper.map(servicioGrabado, ServicioDTO.class);
    }

    public List<ServicioDTO> listar() {
        return servicioRepositorio.findAll().stream().
                map(servicio -> modelMapper.
                        map(servicio, ServicioDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Servicio editar(Servicio servicio) {
        if(servicioRepositorio.existsById(servicio.getId()))
            return servicioRepositorio.save(servicio);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if(!servicioRepositorio.existsById(id))
            throw new RuntimeException("No existe el servicio con el id " + id);
        servicioRepositorio.deleteById(id);
    }

    @Transactional()
    public List<ServicioDTO> buscarServiciosPorNombreMedicamento(String nombreMedicamento){
        return servicioRepositorio.buscarServiciosPorNombreMedicamento(nombreMedicamento).stream()
                .map(servicio -> modelMapper.map(servicio, ServicioDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional()
    public List<ServicioDTO> listarPorCentro(Long idCentro){
        return servicioRepositorio.listarPorCentro(idCentro).stream()
                .map(servicio -> modelMapper.map(servicio, ServicioDTO.class))
                .collect(Collectors.toList());
    }

}
