package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.CentroMedClienteFav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroMedClienteFavRepositorio extends JpaRepository<CentroMedClienteFav, Long> {
}
