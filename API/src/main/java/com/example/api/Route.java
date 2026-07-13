package com.example.api;

import java.math.BigDecimal;

public record Route(int id, int originPlanetId, int destinationPlanetId, BigDecimal distance) {
}
