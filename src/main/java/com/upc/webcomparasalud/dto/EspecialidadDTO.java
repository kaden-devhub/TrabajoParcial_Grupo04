package com.upc.webcomparasalud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDTO {
    private Long id;
    private String nombre;
    private String descripcion;
}
