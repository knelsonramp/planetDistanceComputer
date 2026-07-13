package com.example.api;

import java.math.BigDecimal;

public record RouteWithNames(
        int id,
        int originPlanetId,
        String originPlanetName,
        int destinationPlanetId,
        String destinationPlanetName,
        BigDecimal distance) {
}
