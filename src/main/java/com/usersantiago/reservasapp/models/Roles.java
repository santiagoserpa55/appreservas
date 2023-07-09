package com.usersantiago.reservasapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Roles {
  @Id
//  @Column(name = "IdRol")
  private short idRol;
  private String nombre;
  private String descripcion;

  public Roles() {
  }

  public Roles(short idRol, String nombre, String descripcion) {
    this.idRol = idRol;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public Roles(String nombre, String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  public short getIdRol() {
    return idRol;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
}
