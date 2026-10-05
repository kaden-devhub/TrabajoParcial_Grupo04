package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.EspecialidadDTO;
import com.upc.webcomparasalud.entidades.Especialidad;
import com.upc.webcomparasalud.repositorios.EspecialidadRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadServicio {
    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public EspecialidadDTO insertar(EspecialidadDTO especialidadDTO){
        //CONVIRTIENDO DTO A ENTIDAD (IMPORTANTE)
        Especialidad especialidad = modelMapper.map(especialidadDTO, Especialidad.class);
        Especialidad especialidadGrabado = especialidadRepositorio.save(especialidad);
        return modelMapper.map(especialidadGrabado, EspecialidadDTO.class);
    }

    public List<EspecialidadDTO> listar(){
        return especialidadRepositorio.findAll().stream().
                map(especialidad -> modelMapper.
                        map(especialidad, EspecialidadDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Especialidad editar(Especialidad especialidad) {
        if (especialidadRepositorio.existsById(especialidad.getId()))
            return especialidadRepositorio.save(especialidad);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!especialidadRepositorio.existsById(id))
            throw new RuntimeException ("No existe la especialidad con el id: " + id);
        especialidadRepositorio.deleteById(id);
    }
}
