package psp.exercicio8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tartaruga extends Thread {

    private Carrera car;

    public Tartaruga(Carrera carrera) {
        car = carrera;
    }

    @Override
    public void run() {
        // Invocamos el metodo sincronizado de la clase carrera
        try {
            System.out.println("Tartaruga posición 1");
            car.tTartaruga();
        } catch (InterruptedException ex) {
            Logger.getLogger(Tartaruga.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
