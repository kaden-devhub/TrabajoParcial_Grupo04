package com.upc.webcomparasalud.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nommbreComercial;
    private String principioActivo;
    private String laboratorio;
    private String presentacion;
    private LocalDate fechaRegistro;
    private String descripcion;
    private double precio;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "id_centroMedico")
    private CentroMedico centroMedico;
}
