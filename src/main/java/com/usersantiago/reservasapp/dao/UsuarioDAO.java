package com.usersantiago.reservasapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.usersantiago.reservasapp.models.Usuarios;

@Repository
public class UsuarioDAO {

  JdbcTemplate jdbcTemplate;

  private static final String SELECT_QUERY_SQL = "SELECT * FROM usuarios";
  private static final String INSERT_QUERY_SQL = "INSERT INTO usuarios (id_usuario, nombres, apellidos, "
      + "tipo_documento, identificacion, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

  UsuarioDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Usuarios> getUsers() {
    return jdbcTemplate.query(SELECT_QUERY_SQL, new RowMapper<Usuarios>() {
      public Usuarios mapRow(ResultSet rs, int rowNum) throws SQLException {
        Usuarios users = new Usuarios();
        users.setIdUsuario(rs.getShort("id_usuario"));
        users.setNombres(rs.getString("nombres"));
        users.setApellidos(rs.getString("apellidos"));
        users.setTipoDocumento(rs.getString("tipo_documento"));
        users.setIdentificacion(rs.getString("identificacion"));
        users.setEmail(rs.getString("email"));
        users.setPassword(rs.getString("password"));
        return users;
      }
    });
  }

  public Short createUser(Usuarios user) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update((PreparedStatementCreator) connection -> {
      PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_SQL, new String[] { "id_usuario" });
      ps.setShort(1, user.getIdUsuario());
      ps.setString(2, user.getNombres());
      ps.setString(3, user.getApellidos());
      ps.setString(4, user.getTipoDocumento());
      ps.setString(5, user.getIdentificacion());
      ps.setString(6, user.getEmail());
      ps.setString(7, user.getPassword());
      return ps;
    }, keyHolder);
    Short idUsuario = keyHolder.getKey().shortValue();
    System.out.println(idUsuario);
    return idUsuario;
  }

  public Usuarios findByCorreoElectronico(String email) {
    String sql = "SELECT * FROM usuarios WHERE email = ?";
    return jdbcTemplate.queryForObject(sql, new Object[] { email }, (rs, rowNum) -> {

      Usuarios admin = new Usuarios();
      admin.setIdUsuario(rs.getShort("id_usuario"));
      admin.setEmail(rs.getString("email"));
      admin.setPassword(rs.getString("password"));
      return admin;
    });
  }


}
