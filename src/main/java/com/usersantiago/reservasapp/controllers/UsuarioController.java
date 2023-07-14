package com.usersantiago.reservasapp.controllers;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.usersantiago.reservasapp.models.Usuarios;
import com.usersantiago.reservasapp.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {
  private final UsuarioService usuarioService;

  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping("lista-usuarios")
  public List<Usuarios> getUsuarios() {
    return this.usuarioService.getUsers();
  }

  @PostMapping("crear-usuario")
  public ResponseEntity<Short> insertarRegistro(@RequestBody Usuarios users) {
    Short idUser = this.usuarioService.savaUser(users);
    return ResponseEntity.ok(idUser);
  }

  @PostMapping("login")
  public ResponseEntity<Object> login(@RequestParam("email") String correoElectronico,
      @RequestParam("password") String password) {

    boolean autenticado = usuarioService.autenticar(correoElectronico, password);
    if (autenticado) {
      ApiResponse response = new ApiResponse("Login exitoso");
//      return ResponseEntity.ok("Login exitoso");
      return ResponseEntity.ok(response);
    } else {
      ApiResponse response = new ApiResponse("Login exitoso");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
  }
  
  @PutMapping("update-user")
  public String updateUser(@RequestParam("id") String idUser, @RequestBody Usuarios user) {
    this.usuarioService.updateUser(idUser, user);
    return "ok";
  }

}
