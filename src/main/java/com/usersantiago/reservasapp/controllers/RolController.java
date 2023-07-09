package com.usersantiago.reservasapp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;


import com.usersantiago.reservasapp.models.Roles;
import com.usersantiago.reservasapp.services.RolService;

@RestController
@RequestMapping(path = "api/v1/roles")
public class RolController {
  private final RolService rolService;

  public RolController(RolService rolService) {
    this.rolService = rolService;
  }

  @GetMapping("listaroles")
  public List<Roles> roles() {
    return this.rolService.getRoles();
  }
  
  @PostMapping("crear-rol")
  public String newRol(@RequestBody Roles roles) {
    this.rolService.saveRol(roles);
    return "ok";
  }
  
}
