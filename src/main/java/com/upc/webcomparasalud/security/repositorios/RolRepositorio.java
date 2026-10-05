package com.upc.webcomparasalud.security.repositorios;

import com.upc.webcomparasalud.security.entidades.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);
}
