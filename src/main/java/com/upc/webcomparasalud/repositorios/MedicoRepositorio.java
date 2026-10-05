package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {

    @Query("select med from Medico med join med.especialidades e " +
            "where e.id = :idEspecialidad and med.centroMedico.id = :idCentroMed")
    List<Medico> filtrarMedicosPorEspecialidadYCentro(@Param("idEspecialidad") Long idEspecialidad,
                                                      @Param("idCentroMed") Long idCentroMed);

}
