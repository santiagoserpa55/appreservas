package com.usersantiago.reservasapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usersantiago.reservasapp.dao.UsuarioDAO;
import com.usersantiago.reservasapp.models.Usuarios;
import com.usersantiago.reservasapp.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UsuarioRepository {
  private final UsuarioDAO userDAO;

  public UsuarioService(UsuarioDAO userDAO) {
    this.userDAO = userDAO;
  }

  public List<Usuarios> getUsers() {
    List<Usuarios> usuarios = this.userDAO.getUsers();
    return usuarios;
  }

  @Override
  public Short savaUser(Usuarios users) {
    int idUser = userDAO.createUser(users);
    Short id = (short) idUser;
    return id;
  }

  @Override
  public boolean autenticar(String correoElectronico, String contrasenia) {
    Usuarios admin = userDAO.findByCorreoElectronico(correoElectronico);
    if (admin != null && admin.getPassword().equals(contrasenia)) {
      return true; // Autenticación exitosa
    }
    return false; // Autenticación fallida
  }

}
