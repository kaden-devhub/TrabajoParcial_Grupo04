package com.upc.webcomparasalud.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numerocolegiatura;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    @ManyToOne
    @JoinColumn(name = "id_centroMedico")
    private CentroMedico centroMedico;

    @ManyToMany
    @JoinTable(name ="medico_especialidad",
        joinColumns = @JoinColumn(name = "id_medico"),
        inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private Set<Especialidad> especialidades;

}

