package com.example.api;

import java.math.BigDecimal;

public record PlanetConnection(int planetId, String planetName, BigDecimal distance) {
}
