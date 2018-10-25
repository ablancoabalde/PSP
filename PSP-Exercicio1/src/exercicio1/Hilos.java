package exercicio1;


import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilos extends Thread {
    private String nombre;
    
    public Hilos(String nombre){
        this.nombre=nombre;
        this.start();
    }
    
    
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(nombre+": "+i);

                Thread.sleep(this.numAzar());

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int numAzar() {

        return (int) (Math.random() * 1000 + 50);

    }

}
