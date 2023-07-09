package com.usersantiago.reservasapp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.usersantiago.reservasapp.repositories.RolRepository;
import com.usersantiago.reservasapp.dao.RolesDAO;
import com.usersantiago.reservasapp.models.Roles;

@Service
public class RolService implements RolRepository {
 
  private final RolesDAO rolesDAO;
  
  public RolService(RolesDAO rolesDAO) {
    this.rolesDAO = rolesDAO;
  }

  public List<Roles> getRoles() {
    List<Roles> roles = this.rolesDAO.listRoles();
    return roles;
  }

  @Override
  public void saveRol(Roles roles) {
    rolesDAO.saveRoles(roles);  
  }
  
}
