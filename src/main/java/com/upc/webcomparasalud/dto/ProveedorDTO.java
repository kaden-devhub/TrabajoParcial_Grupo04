package com.upc.webcomparasalud.dto;

import com.upc.webcomparasalud.security.entidades.Rol;
import com.upc.webcomparasalud.security.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorDTO {
    private Long id;
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String direccion;
}
