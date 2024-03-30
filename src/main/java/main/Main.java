package main;


import entities.Client;
import entities.Planet;
import services.ClientService;
import services.PlanetService;
import utils.MigrationExecutor;
import utils.PropsReader;

public class Main {
    public static void main(String[] args) {
        MigrationExecutor.executeMigration(PropsReader.getDbConnectionUrl(),
                PropsReader.getDbUsername(), PropsReader.getDbPassword());

        testClientCruds();

        testPlanetCruds();
    }
    private static void testPlanetCruds(){
        PlanetService planetService = new PlanetService();

        planetService.getAllPlanets().forEach(System.out::println);

        Planet planet = new Planet("EARTH", "Earth");
        planetService.createPlanet(planet);

        System.out.println(planetService.getPlanetById("EARTH"));

        planet.setName("Earth_Updated");
        planetService.updatePlanet(planet);

        System.out.println(planetService.getPlanetById("EARTH"));

        planetService.deletePlanet(planet);

        planetService.getAllPlanets().forEach(System.out::println);
    }

    private static void testClientCruds(){
        ClientService clientService = new ClientService();

        clientService.getAllClients().forEach(System.out::println);

        Client client = new Client();
        client.setName("Test_Client");
        clientService.createClient(client);

        System.out.println(clientService.getClientById(15L));

        client.setName("Test_Client_Updated");
        clientService.updateClient(client);

        System.out.println(clientService.getClientById(15L));

        clientService.deleteClient(client);

        clientService.getAllClients().forEach(System.out::println);
    }
}
