package fr.bnts.heptathlon.main_server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {
        try {
            Service service = new ServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Service", service);
            System.out.println("Main Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
