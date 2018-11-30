package psp.exercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lebre extends Thread {

    private Carrera car;

    public Lebre(Carrera carrera) {
        car = carrera;
    }

    @Override
    public void run() {
        // Invocamos el metodo sincronizado de la clase carrera
        try {
            System.out.println("Lebre posición 1");
            car.tLebre();
        } catch (InterruptedException ex) {
            Logger.getLogger(Lebre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
