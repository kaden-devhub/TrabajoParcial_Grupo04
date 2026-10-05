package com.upc.webcomparasalud.entidades;

import com.upc.webcomparasalud.security.entidades.Rol;
import com.upc.webcomparasalud.security.entidades.Usuario;
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
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String direccion;
}
