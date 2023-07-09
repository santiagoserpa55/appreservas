package com.usersantiago.reservasapp.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.usersantiago.reservasapp.models.Usuarios;

@Repository
public interface UsuarioRepository {
  List<Usuarios> getUsers();
  Short savaUser(Usuarios users);
  boolean autenticar(String correoElectronico, String contraseña);
}
