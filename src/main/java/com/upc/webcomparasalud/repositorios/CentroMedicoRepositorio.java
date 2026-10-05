package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.CentroMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CentroMedicoRepositorio extends JpaRepository<CentroMedico, Long> {
    @Query("select cm from CentroMedico cm " +
            "where lower(cm.distrito) like lower(concat('%', :filtro, '%')) " +
            "or lower(cm.distrito) like lower(concat('%', :filtro, '%'))")
    List<CentroMedico> buscarPorNombreDistrito(@Param("filtro") String filtro);

}
