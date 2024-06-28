package fr.bnts.heptathlon.main_server;

import fr.bnts.heptathlon.main_server.rmi.ServiceConnector;

import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        ServiceConnector.host();
        System.out.println("Main Server is running");
    }
}
