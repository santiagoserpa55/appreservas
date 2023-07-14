package com.usersantiago.reservasapp.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.usersantiago.reservasapp.models.Reservas;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository
public class ReservasDAO {

  private final JdbcTemplate jdbcTemplate;

  String SQL_JOIN = "SELECT u.nombres, u.apellidos, u.tipo_documento, u.identificacion,"
      + "u.email, r.fecha_reserva, r.tipo_reserva, r.cantidad_personas, r.estado " + "FROM reservas AS r "
      + "INNER JOIN usuarios AS u ON r.id_usuario = u.id_usuario " + "ORDER BY r.fecha_reserva DESC";
  String SQL_JOIN_FULL = "SELECT u.nombres, u.apellidos, u.tipo_documento, u.identificacion, u.email,\n"
      + "r.id_reserva, r.fecha_reserva, r.tipo_reserva, r.cantidad_personas, r.estado, r.observaciones, r.id_usuario\n"
      + "FROM reservas AS r INNER JOIN usuarios AS u ON r.id_usuario = u.id_usuario WHERE u.identificacion = ?";
  String INSERT_QUERY_SQL = "INSERT INTO reservas (id_reserva, fecha_reserva, tipo_reserva, cantidad_personas,"
      + "observaciones, estado, id_usuario)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";

  public ReservasDAO(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public List<Map<String, Object>> getRelatedData() {
    return jdbcTemplate.queryForList(SQL_JOIN);
  }

  public List<Map<String, Object>> getRelatedDataFull(String userIdentification) {
    return jdbcTemplate.queryForList(SQL_JOIN_FULL, userIdentification);
  }

  public void createReserva(Reservas reserva) {
    reserva.setEstado("SOLICITADO");
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update((PreparedStatementCreator) connection -> {
      PreparedStatement ps = connection.prepareStatement(INSERT_QUERY_SQL, new String[] { "id_usuario" });
      ps.setShort(1, reserva.getIdReserva());
      ps.setDate(2, reserva.getFechaReserva());
      ps.setString(3, reserva.getTipoReserva());
      ps.setInt(4, reserva.getCantidadPersonas());
      ps.setString(5, reserva.getObservaciones());
      ps.setString(6, reserva.getEstado());
      ps.setShort(7, reserva.getIdUsuario());
      return ps;
    }, keyHolder);
  }

  public void updateReserva(String idReserva, Reservas reserva) {
    String sql = "UPDATE reservas SET fecha_reserva = ?, tipo_reserva = ?, cantidad_personas = ?,"
        + "observaciones = ? WHERE id_reserva = ?";
    jdbcTemplate.update(sql, reserva.getFechaReserva(), reserva.getTipoReserva(), reserva.getCantidadPersonas(),
        reserva.getObservaciones(), idReserva);
  }

  public int confirmarReserva(String idReserva, Reservas reserva) {
    String sql = "UPDATE reservas SET estado = ? WHERE id_reserva = ?";
   return jdbcTemplate.update(sql, reserva.getEstado(), idReserva);
  }





}
