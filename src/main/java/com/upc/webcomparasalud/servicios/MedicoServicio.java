package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.MedicoDTO;
import com.upc.webcomparasalud.entidades.Medico;
import com.upc.webcomparasalud.repositorios.MedicoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServicio {
    @Autowired
    private MedicoRepositorio medicoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public MedicoDTO insertar(MedicoDTO medicoDTO) {
        Medico medico = modelMapper.map(medicoDTO, Medico.class);
        Medico medicoGrabado = medicoRepositorio.save(medico);
        return modelMapper.map(medicoGrabado, MedicoDTO.class);
    }

    public List<MedicoDTO> listar() {
        return medicoRepositorio.findAll().stream().
                map(medico -> modelMapper.
                        map(medico, MedicoDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Medico editar(Medico medico) {
        if (medicoRepositorio.existsById(medico.getId()))
            return medicoRepositorio.save(medico);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!medicoRepositorio.existsById(id))
            throw new RuntimeException ("No existe el medico con el id: " + id);
        medicoRepositorio.deleteById(id);
    }

    @Transactional()
    public List<MedicoDTO> filtrarMedicosPorEspecialidadYCentro(Long idEspecialidad, Long idCentroMed){
        return medicoRepositorio.filtrarMedicosPorEspecialidadYCentro(idEspecialidad, idCentroMed)
                .stream()
                .map(medico -> modelMapper
                        .map(medico, MedicoDTO.class))
                .collect(Collectors.toList());
    }
}
