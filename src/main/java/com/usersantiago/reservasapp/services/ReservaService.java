package com.usersantiago.reservasapp.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.usersantiago.reservasapp.dao.ReservasDAO;
import com.usersantiago.reservasapp.models.Reservas;

@Service
public class ReservaService {
  private final ReservasDAO reservaDAO;

  public ReservaService(ReservasDAO reservaDAO) {
    this.reservaDAO = reservaDAO;
  }

  public void saveReservas(@RequestBody Reservas reserva) {
    reservaDAO.createReserva(reserva);
  }

  public List<Map<String, Object>> getRelatedData() {
    return reservaDAO.getRelatedData();
  }

  public List<Map<String, Object>> getRelatedDataFull(String id) {
    return reservaDAO.getRelatedDataFull(id);
  }

  public void confirmarReserva(String idReserva, Reservas reserva) {
    reservaDAO.confirmarReserva(idReserva, reserva);
  }

}