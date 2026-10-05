package com.upc.webcomparasalud.security.controladores;


import com.upc.webcomparasalud.security.dto.AuthRequestDTO;
import com.upc.webcomparasalud.security.dto.AuthResponseDTO;
import com.upc.webcomparasalud.security.dto.RegistroDTO;
import com.upc.webcomparasalud.security.servicios.CustomUserDetailsService;
import com.upc.webcomparasalud.security.servicios.UsuarioServicio;
import com.upc.webcomparasalud.security.utils.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "${ip.frontend}", allowCredentials = "true", exposedHeaders = "Authorization") //para cloud
@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final UsuarioServicio usuarioServicio;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                          CustomUserDetailsService userDetailsService, UsuarioServicio usuarioServicio ) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.usuarioServicio = usuarioServicio;
    }

    @PostMapping("/authenticate")
        public ResponseEntity<AuthResponseDTO> createAuthenticationToken(@RequestBody AuthRequestDTO authRequest) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );


        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        Set<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Authorization", token);
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setRoles(roles);
        authResponseDTO.setJwt(token);
        return ResponseEntity.ok().headers(responseHeaders).body(authResponseDTO);

    }

    @PostMapping("/register")
    public ResponseEntity<String> registrar(@RequestBody RegistroDTO request) {
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body("Usuario y contraseña obligatorios");
        }
        String rol = request.getRol();
        if (!"CLIENTE".equalsIgnoreCase(rol) && !"PROVEEDOR".equalsIgnoreCase(rol)) {
            return ResponseEntity.badRequest().body("Rol no permitido. Use CLIENTE o PROVEEDOR");
        }
        if (usuarioServicio.existe(request.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El usuario ya existe");
        }
        usuarioServicio.registrar(request.getUsername(), request.getPassword(), rol);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");
    }
}
