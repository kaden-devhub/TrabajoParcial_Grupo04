package com.upc.webcomparasalud.security.dto;


import lombok.Data;

@Data
public class RegistroDTO {
    private String username;
    private String password;
    private String rol;
}
