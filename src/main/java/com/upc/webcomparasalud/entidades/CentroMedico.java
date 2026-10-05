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
public class CentroMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private double latitud;
    private double longitud;
    private String tipoGestion;
    private String telefono;
    private String distrito;
    private String ciudad;
    @ManyToOne
    @JoinColumn(name = "id_administrador")
    private Administrador administrador;
}
