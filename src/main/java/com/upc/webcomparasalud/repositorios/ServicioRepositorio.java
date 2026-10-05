package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

    @Query("select s from Servicio s join fetch s.medicamento m " +
            "where lower(m.nommbreComercial) like lower(concat('%', :nombreMedicamento, '%'))")
    List<Servicio> buscarServiciosPorNombreMedicamento(@Param("nombreMedicamento") String nombreMedicamento);

    @Query("select s from Servicio s join fetch s.centroMedico cm " +
            "where cm.id = :idCentro order by s.precio asc")
    List<Servicio> listarPorCentro(@Param("idCentro") Long idCentro);
}
