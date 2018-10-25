package exercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos extends Thread {

    private String nombre;

    public Hilos() {

        Hilos h1 = new Hilos("Hilo1");

        Hilos h2 = new Hilos("Hilo2");

        Hilos h3 = new Hilos("Hilo3");

        Hilos h4 = new Hilos("Hilo4");

    }

    public Hilos(String nombre) {
        this.nombre = nombre;
        this.start();

    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(nombre + ": " + i);

            }
            System.out.println("acabe");
            Thread.sleep(1000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
