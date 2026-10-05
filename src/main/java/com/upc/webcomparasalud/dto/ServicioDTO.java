package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.entidades.Medicamento;
import com.upc.webcomparasalud.entidades.Medico;
import com.upc.webcomparasalud.entidades.TipoServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {
    private Long id;
    private String nombre;
    private double precio;
    private String descripcion;
    private CentroMedico centroMedico;
    private Medicamento medicamento;
    private Medico medico;
    private TipoServicio tipoServicio;

}
