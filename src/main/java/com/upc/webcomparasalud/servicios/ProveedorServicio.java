package com.upc.webcomparasalud.servicios;

import com.upc.webcomparasalud.dto.ProveedorDTO;
import com.upc.webcomparasalud.entidades.Proveedor;
import com.upc.webcomparasalud.repositorios.ProveedorRepositorio;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorServicio {
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    @Transactional
    public ProveedorDTO insertar(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        Proveedor proveedorGrabado = proveedorRepositorio.save(proveedor);
        return modelMapper.map(proveedorGrabado, ProveedorDTO.class);
    }

    public List<ProveedorDTO> listar() {
        return proveedorRepositorio.findAll().stream().
                map(proveedor -> modelMapper.
                        map(proveedor, ProveedorDTO.class)).
                collect(Collectors.toList());
    }

    @Transactional()
    public Proveedor editar(Proveedor proveedor) {
        if(proveedorRepositorio.existsById(proveedor.getId()))
            return proveedorRepositorio.save(proveedor);
        return null;
    }

    @Transactional()
    public void eliminar(Long id) {
        if(!proveedorRepositorio.existsById(id))
            throw new RuntimeException("No existe el proveedor con el id " + id);
        proveedorRepositorio.deleteById(id);
    }
}
