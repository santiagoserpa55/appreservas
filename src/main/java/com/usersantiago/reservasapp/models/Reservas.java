package com.usersantiago.reservasapp.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reservas {
  @Id
  private short idReserva;
  private Date fechaReserva;
  private String tipoReserva;
  private byte cantidadPersonas;
  private String observaciones;
  private String estado;
  private short idUsuario;
  
  public Reservas() {
  }

  public Reservas(short idReserva, Date fechaReserva, String tipoReserva, byte cantidadPersonas, String observaciones,
      String estado, short idUsuario) {
    this.idReserva = idReserva;
    this.fechaReserva = fechaReserva;
    this.tipoReserva = tipoReserva;
    this.cantidadPersonas = cantidadPersonas;
    this.observaciones = observaciones;
    this.estado = estado;
    this.idUsuario = idUsuario;
  }

  public Reservas(Date fechaReserva, String tipoReserva, byte cantidadPersonas, String observaciones, String estado,
      short idUsuario) {
    this.fechaReserva = fechaReserva;
    this.tipoReserva = tipoReserva;
    this.cantidadPersonas = cantidadPersonas;
    this.observaciones = observaciones;
    this.estado = estado;
    this.idUsuario = idUsuario;
  }

  public short getIdReserva() {
    return idReserva;
  }
  
  public void setIdReserva(short idReserva) {
    this.idReserva = idReserva;
  }

  public Date getFechaReserva() {
    return fechaReserva;
  }

  public void setFechaReserva(Date fechaReserva) {
    this.fechaReserva = fechaReserva;
  }

  public String getTipoReserva() {
    return tipoReserva;
  }

  public void setTipoReserva(String tipoReserva) {
    this.tipoReserva = tipoReserva;
  }

  public byte getCantidadPersonas() {
    return cantidadPersonas;
  }

  public void setCantidadPersonas(byte cantidadPersonas) {
    this.cantidadPersonas = cantidadPersonas;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public short getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(short idUsuario) {
    this.idUsuario = idUsuario;
  }
  
}
