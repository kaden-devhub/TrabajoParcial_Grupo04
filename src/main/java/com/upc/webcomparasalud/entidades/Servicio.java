package com.upc.webcomparasalud.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_centroMedico")
    private CentroMedico centroMedico;
    @ManyToOne
    @JoinColumn(name = "id_medicamento")
    private Medicamento medicamento;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_tipoServicio")
    private TipoServicio tipoServicio;
}
