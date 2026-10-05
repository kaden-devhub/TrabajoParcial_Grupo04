package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicioRepositorio extends JpaRepository<TipoServicio, Long> {
}
