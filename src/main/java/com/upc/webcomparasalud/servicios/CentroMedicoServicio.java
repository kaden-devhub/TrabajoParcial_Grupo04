package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.CentroMedicoDTO;
import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.repositorios.CentroMedicoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroMedicoServicio {
    @Autowired
    private CentroMedicoRepositorio centroMedicoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public CentroMedicoDTO insertar(CentroMedicoDTO centroMedicoDTO){
        CentroMedico centroMedico = modelMapper.map(centroMedicoDTO, CentroMedico.class);
        CentroMedico centroMedicoGrabado = centroMedicoRepositorio.save(centroMedico);
        return modelMapper.map(centroMedicoGrabado, CentroMedicoDTO.class);
    }

    public List<CentroMedicoDTO> listar(){
        return centroMedicoRepositorio.findAll().stream().
                map(centroMedico -> modelMapper.
                        map(centroMedico, CentroMedicoDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public CentroMedico editar(CentroMedico centroMedico) {
        if (centroMedicoRepositorio.existsById(centroMedico.getId()))
            return centroMedicoRepositorio.save(centroMedico);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!centroMedicoRepositorio.existsById(id))
            throw new RuntimeException ("No existe el centro medico con el id: " + id);
        centroMedicoRepositorio.deleteById(id);
    }


    @Transactional()
    public List<CentroMedicoDTO> buscarPorNombreDistrito(String filtro) {
        return centroMedicoRepositorio.buscarPorNombreDistrito(filtro)
                .stream()
                .map(centroMedico -> modelMapper
                        .map(centroMedico, CentroMedicoDTO.class))
                .collect(Collectors.toList());
    }



}
