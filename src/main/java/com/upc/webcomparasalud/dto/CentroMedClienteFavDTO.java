package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.entidades.CentroMedico;
import com.upc.webcomparasalud.entidades.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CentroMedClienteFavDTO {
    private Cliente cliente;
    private CentroMedico centroMedico;
}
