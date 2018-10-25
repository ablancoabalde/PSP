package exercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Hilos extends Thread implements Runnable {

    Thread h;

    public static int x = 0;
    String nombre;

    public Hilos() throws InterruptedException {
        x += 1;

        System.out.println(getName() + " comenzo");
        while (x < 5) {
            h=new Hilos();
            h.join();
            this.start();

        }

    }

    @Override
    public void run() {
        int nom = 0;

        boolean condicion = true;
        while (condicion) {
            for (int i = 0; i <= 2; i++) {

                System.out.println(Thread.currentThread().getName() + " hijo " + i + " comenzo");

                try {
                    Thread.sleep(this.numAzar());
                    if (i == 2) {
                        h.join();
                        condicion = false;
                        System.out.println(Thread.currentThread().getName() + " acabo");
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    private int numAzar() {

        return (int) (Math.random() * 10 + 60);

    }

}
