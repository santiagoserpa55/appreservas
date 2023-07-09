package com.usersantiago.reservasapp.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.usersantiago.reservasapp.models.Roles;

@Repository
public interface RolRepository {
  List<Roles> getRoles();
  void saveRol(Roles roles);
}
