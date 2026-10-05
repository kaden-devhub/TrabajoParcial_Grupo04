package com.upc.webcomparasalud.security.dto;


import lombok.Data;

import java.util.Set;

@Data
public class AuthResponseDTO {
    private String jwt;
    private Set<String> roles;
}
