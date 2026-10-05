package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.CentroMedClienteFavDTO;
import com.upc.webcomparasalud.entidades.CentroMedClienteFav;
import com.upc.webcomparasalud.repositorios.CentroMedClienteFavRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroMedClienteFavServicio {
    @Autowired
    private CentroMedClienteFavRepositorio centroMedClienteFavRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public CentroMedClienteFavDTO insertar(CentroMedClienteFavDTO centroMedClienteFavDTO) {
        CentroMedClienteFav centroMedClienteFav = modelMapper.map(centroMedClienteFavDTO, CentroMedClienteFav.class);
        CentroMedClienteFav centroMedClienteFavGrabado = centroMedClienteFavRepositorio.save(centroMedClienteFav);
        return modelMapper.map(centroMedClienteFavGrabado, CentroMedClienteFavDTO.class);
    }

    public List<CentroMedClienteFavDTO> listar(){
        return centroMedClienteFavRepositorio.findAll().stream().
                map(centroMedClienteFav -> modelMapper.
                        map(centroMedClienteFav, CentroMedClienteFavDTO.class)).
                collect(Collectors.toList());
    }

}
