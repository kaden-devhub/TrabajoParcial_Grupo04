package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.entidades.Especialidad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoDTO {
    private Long id;
    private Integer numerocolegiatura;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private CentroMedico centroMedico;
    private Set<Especialidad> especialidades;

}
