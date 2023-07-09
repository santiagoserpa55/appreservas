package com.usersantiago.reservasapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.usersantiago.reservasapp.models.Roles;


@Repository
public class RolesDAO {
  JdbcTemplate jdbcTemplate;
  
  RolesDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;        
  }
  
  public List<Roles> listRoles() {
    String querySQL = "SELECT * FROM roles";
    
    return jdbcTemplate.query(querySQL, new RowMapper<Roles>() {
      @Override
      public Roles mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Roles roles = new Roles();
        roles.setIdRol(resultSet.getShort("id_rol"));
        roles.setNombre(resultSet.getString("nombre"));
        roles.setDescripcion(resultSet.getString("descripcion"));
        return roles;
      }    
    });
  }

  public void saveRoles(Roles roles) {
    String querySQL = "INSERT INTO roles (id_rol, nombre, descripcion) VALUES (?, ?, ?)";
    jdbcTemplate.update(querySQL, roles.getIdRol(), roles.getNombre(), roles.getDescripcion());
  }

}
