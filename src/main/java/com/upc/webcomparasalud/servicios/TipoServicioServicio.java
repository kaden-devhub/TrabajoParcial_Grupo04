package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.TipoServicioDTO;
import com.upc.webcomparasalud.entidades.TipoServicio;
import com.upc.webcomparasalud.repositorios.TipoServicioRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoServicioServicio {
    @Autowired
    private TipoServicioRepositorio tipoServicioRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public TipoServicioDTO insertar(TipoServicioDTO tipoServicioDTO) {
        TipoServicio tipoServicio = modelMapper.map(tipoServicioDTO, TipoServicio.class);
        TipoServicio tipoServicioGrabado = tipoServicioRepositorio.save(tipoServicio);
        return modelMapper.map(tipoServicioGrabado, TipoServicioDTO.class);
    }

    public List<TipoServicioDTO> listar() {
        return tipoServicioRepositorio.findAll().stream().
                map(tipoServicio -> modelMapper.
                        map(tipoServicio, TipoServicioDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public TipoServicio editar(TipoServicio tipoServicio) {
        if(tipoServicioRepositorio.existsById(tipoServicio.getId()))
            return tipoServicioRepositorio.save(tipoServicio);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if(!tipoServicioRepositorio.existsById(id))
            throw new RuntimeException("No existe el tipo de servicio con el id " + id);
        tipoServicioRepositorio.deleteById(id);
    }
}
