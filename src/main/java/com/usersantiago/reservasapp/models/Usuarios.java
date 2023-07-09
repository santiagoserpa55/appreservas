package com.usersantiago.reservasapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuarios {
  @Id
  private short idUsuario;
  private String nombres;
  private String apellidos;
  private String tipoDocumento;
  private String identificacion;
  private String email;
  private String password;
  private short idRol;

  public Usuarios() {
  }

  public Usuarios(String nombres, String apellidos, String tipoDocumento, String identificacion, String email,
      String password, short idRol) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.tipoDocumento = tipoDocumento;
    this.identificacion = identificacion;
    this.email = email;
    this.password = password;
    this.idRol = idRol;
  }

  public Usuarios(short id_usuario, String nombres, String apellidos, String tipoDocumento, String identificacion,
      String email, String password, short idRol) {
    this.idUsuario = id_usuario;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.tipoDocumento = tipoDocumento;
    this.identificacion = identificacion;
    this.email = email;
    this.password = password;
    this.idRol = idRol;
  }

  public short getId_usuario() {
    return idUsuario;
  }

  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public short getIdRol() {
    return idRol;
  }

  public short getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(short idUsuario) {
    this.idUsuario = idUsuario;
  }

  public void setIdRol(short idRol) {
    this.idRol = idRol;
  }

}
