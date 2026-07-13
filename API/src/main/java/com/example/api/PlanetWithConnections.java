package com.example.api;

import java.util.List;

public record PlanetWithConnections(int planetId, String planetName, List<PlanetConnection> connections) {
}
