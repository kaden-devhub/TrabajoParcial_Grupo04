package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
}
