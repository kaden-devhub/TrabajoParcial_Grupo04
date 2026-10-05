package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.entidades.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentoDTO {
    private Long id;
    private String nommbreComercial;
    private String principioActivo;
    private String laboratorio;
    private String presentacion;
    private LocalDate fechaRegistro;
    private String descripcion;
    private double precio;
    private int stock;
    private Proveedor proveedor;
    private CentroMedico centroMedico;

}
