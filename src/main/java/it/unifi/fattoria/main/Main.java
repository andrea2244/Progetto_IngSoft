package it.unifi.fattoria.main;

import it.unifi.fattoria.orm.ConnectionManager;

public class Main {
    public static void main(String[] args) throws Exception {
        ConnectionManager.getInstance().getConnection();
        System.out.println("Simulatore fattoria avviato: database pronto.");
    }
}
