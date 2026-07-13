package com.example.api;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DerbyHelloController {

    private final JdbcTemplate jdbcTemplate;

    public DerbyHelloController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/derby-hello")
    public String derbyHello() {
        return jdbcTemplate.queryForObject("SELECT message FROM greeting WHERE id = 1", String.class);
    }

    @GetMapping("/planets")
    public List<Planet> planets() {
        return jdbcTemplate.query(
                "SELECT id, name FROM planets ORDER BY id",
                (rs, rowNum) -> new Planet(rs.getInt("id"), rs.getString("name")));
    }

    @GetMapping("/routes")
    public List<Route> routes() {
        return jdbcTemplate.query(
                "SELECT id, origin_planet_id, destination_planet_id, distance FROM routes ORDER BY id",
                (rs, rowNum) -> new Route(
                        rs.getInt("id"),
                        rs.getInt("origin_planet_id"),
                        rs.getInt("destination_planet_id"),
                        rs.getBigDecimal("distance")));
    }

    @GetMapping("/routes-with-names")
    public List<RouteWithNames> routesWithNames() {
        return jdbcTemplate.query(
                """
                SELECT r.id, r.origin_planet_id, o.name AS origin_planet_name,
                       r.destination_planet_id, d.name AS destination_planet_name, r.distance
                FROM routes r
                JOIN planets o ON o.id = r.origin_planet_id
                JOIN planets d ON d.id = r.destination_planet_id
                ORDER BY r.id
                """,
                (rs, rowNum) -> new RouteWithNames(
                        rs.getInt("id"),
                        rs.getInt("origin_planet_id"),
                        rs.getString("origin_planet_name"),
                        rs.getInt("destination_planet_id"),
                        rs.getString("destination_planet_name"),
                        rs.getBigDecimal("distance")));
    }

}
