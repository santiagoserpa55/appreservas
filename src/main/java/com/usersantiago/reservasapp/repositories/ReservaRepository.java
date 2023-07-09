package com.usersantiago.reservasapp.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.usersantiago.reservasapp.models.Reservas;

@Repository
public interface ReservaRepository {
  List<Reservas> getReservas();
  void saveReservas(Reservas reservas);
  List<Reservas> obtenerReservaPorId(String id);
  void confirmarReserva(String id, Reservas reserva);
}
