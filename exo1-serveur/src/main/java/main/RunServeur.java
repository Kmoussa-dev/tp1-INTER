package main;

import jakarta.xml.ws.Endpoint;
import service.Facade;
import service.FacadeImpl;

public class RunServeur {

    public static void main(String[] args) {
        Facade server = new FacadeImpl();
        Endpoint endpoint = Endpoint.publish("http://localhost:9191/annuaire",server);
        System.out.println("Serveur lancé en attente de connexions...");
    }
}
