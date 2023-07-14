package com.usersantiago.reservasapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  
  @PutMapping("confirmar-reserva")
  public ResponseEntity<String> confirmarReserva(@RequestParam("id") String idReserva, @RequestBody Reservas reserva) {
    this.reservaService.confirmarReserva(idReserva, reserva);
    String responseBody = "OK";
    return ResponseEntity.status(HttpStatus.OK)
        .header("Content-Type","application/json")
        .body(responseBody);
  }
  
  @PutMapping("update-reserva")
  public String updateReserva(@RequestParam("id") String idRes, @RequestBody Reservas reserva) {
    this.reservaService.updateReserva(idRes, reserva);
    return "ok";
  }

}
