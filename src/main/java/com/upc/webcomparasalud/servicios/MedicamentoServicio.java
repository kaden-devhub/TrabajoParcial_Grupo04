package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.MedicamentoDTO;
import com.upc.webcomparasalud.entidades.Medicamento;
import com.upc.webcomparasalud.repositorios.MedicamentoRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoServicio {
    @Autowired
    private MedicamentoRepositorio medicamentoRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public MedicamentoDTO insertar(MedicamentoDTO medicamentoDTO) {
        //CONVIRTIENDO OTRA VEZ DTO A ENTIDAD
        Medicamento medicamento = modelMapper.map(medicamentoDTO, Medicamento.class);
        Medicamento medicamentoGrabado = medicamentoRepositorio.save(medicamento);
        return modelMapper.map(medicamentoGrabado, MedicamentoDTO.class);
    }

    public List<MedicamentoDTO> listar() {
        return medicamentoRepositorio.findAll().stream().
                map(medicamento -> modelMapper.
                        map(medicamento, MedicamentoDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Medicamento editar(Medicamento medicamento) {
        if (medicamentoRepositorio.existsById(medicamento.getId()))
            return medicamentoRepositorio.save(medicamento);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if (!medicamentoRepositorio.existsById(id))
            throw new RuntimeException ("No existe el medicamento con el id: " + id);
        medicamentoRepositorio.deleteById(id);
    }

    @Transactional()
    public List<MedicamentoDTO> filtrarPorCategoriaYPrecio(String categoria, double precioMin, double precioMax){
        return medicamentoRepositorio.filtrarPorCategoriaYPrecio( categoria, precioMin,precioMax)
                .stream()
                .map(medicamento -> modelMapper
                        .map(medicamento, MedicamentoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<MedicamentoDTO> filtrarOpciones(String principioActivo, Long idCentroMed, Long idMedicamentoActual){
        return medicamentoRepositorio.filtrarOpciones(principioActivo,idCentroMed, idMedicamentoActual)
                .stream()
                .map(medicamento -> modelMapper
                        .map(medicamento, MedicamentoDTO.class))
                .collect(Collectors.toList());
    }
}
