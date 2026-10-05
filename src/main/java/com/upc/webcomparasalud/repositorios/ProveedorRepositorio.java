package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
}
