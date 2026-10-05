package com.upc.webcomparasalud.repositorios;

import com.upc.webcomparasalud.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long> {
    @Query("select m from Medicamento m " +
            "where lower(m.presentacion) like lower(concat('%', :categoria, '%')) " +
            "and m.precio between :precioMin and :precioMax")
    List<Medicamento> filtrarPorCategoriaYPrecio(@Param("categoria") String categoria,
                                                 @Param("precioMin") double precioMin,
                                                 @Param("precioMax") double precioMax);


    @Query("select m from Medicamento m where m.centroMedico.id = :idCentroMed " +
            "and m.principioActivo = :principioActivo and m.id <> :idMedicamentoActual")
    List<Medicamento> filtrarOpciones(@Param("principioActivo") String principioActivo,
                                      @Param("idCentroMed") Long idCentroMed,
                                      @Param("idMedicamentoActual") Long idMedicamentoActual);
}
