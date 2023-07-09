package com.usersantiago.reservasapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.usersantiago.reservasapp.models.Reservas;
import com.usersantiago.reservasapp.services.ReservaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/v1/reservas")
public class ReservaController {
  private final ReservaService reservaService;

  public ReservaController(ReservaService reservaService) {
    this.reservaService = reservaService;
  }
  
  @GetMapping("listareservas")
  public List<Map<String, Object>> getRelatedData() {
    return reservaService.getRelatedData();
  }
  
  
  @GetMapping("filtrarId")
  public List<Map<String, Object>> getRelatedDataFull(String id) {
    return reservaService.getRelatedDataFull(id);
  }

  @PostMapping("crear-reserva")
  public String newReserva(@RequestBody Reservas reserva) {
    this.reservaService.saveReservas(reserva);
    return "ok";
  }
  
  @PutMapping("actualizar")
  public String confirmarReserva(@RequestParam("id") String idReserva, @RequestBody Reservas reserva) {
    this.reservaService.confirmarReserva(idReserva, reserva);
    return "ok";    
  }

}
