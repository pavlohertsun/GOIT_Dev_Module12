package repositories.interfaces;

import entities.Client;
import entities.Planet;

import java.util.List;

public interface PlanetCrudInterface {
    List<Planet> getAllPlanets();
    Planet getPlanetById(String id);
    boolean createPlanet(Planet planet);
    boolean updatePlanet(Planet planet);
    boolean deletePlanet(Planet planet);
}
