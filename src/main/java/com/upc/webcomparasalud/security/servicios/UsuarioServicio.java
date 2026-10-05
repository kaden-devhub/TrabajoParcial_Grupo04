package com.upc.webcomparasalud.security.servicios;

import com.upc.webcomparasalud.security.entidades.Usuario;
import com.upc.webcomparasalud.security.repositorios.RolRepositorio;
import com.upc.webcomparasalud.security.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio {

     private final UsuarioRepositorio usuarioRepositorio;
     private final RolRepositorio rolRepositorio;
     private final PasswordEncoder passwordEncoder;

    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio,
                           RolRepositorio rolRepositorio,
                           PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.rolRepositorio = rolRepositorio;
        this.passwordEncoder = passwordEncoder;
    }
    public boolean existe(String username) {
        return usuarioRepositorio.existsByUsername(username);
    }

    @Transactional
    public void registrar(String username, String password, String rol) {
        Usuario u = new Usuario();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setRol(rolRepositorio.findByName("ROLE_" + rol.toUpperCase()).orElseThrow());
        usuarioRepositorio.save(u);
    }
}
