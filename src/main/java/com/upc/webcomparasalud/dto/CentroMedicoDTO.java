package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.Administrador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CentroMedicoDTO {
    private Long id;
    private String direccion;
    private double latitud;
    private double longitud;
    private String tipoGestion;
    private String telefono;
    private String distrito;
    private String ciudad;
    private Administrador administrador;

}
