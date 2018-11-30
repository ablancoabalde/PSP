package psp.exercicio9;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Control {

    private int pos = 0;
    private boolean activo = false; // false = ascensor parado / true = ascensor en moviemiento

    public synchronized void tSubir(String piso) {
        // Si el ascensor no está subiendo o bajando, entra en la manda 2 mensajes, y pone una espera de 5 segundos para hacer un amago,
        // si no. Hace un wait y se vuelve a llamar a sí mismo
        if (activo == false) {
            activo = true;
            System.out.println("Subiendo a planta " + piso);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Llego al piso " + piso);
            activo = false;
            notify();
        } else {
            try {
                System.out.println("Ascensor en desplazamiento");
                wait();
                tSubir(piso);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public synchronized void tBajar(String piso) {
        // Si el ascensor no está subiendo o bajando, entra en la manda 2 mensajes, y pone una espera de 5 segundos para hacer un amago,
        // si no. Hace un wait y se vuelve a llamar a sí mismo
        if (activo == false) {
            activo = true;
            System.out.println("Bajando a planta " + piso);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Llego al piso " + piso);
            activo = false;
            notify();
        } else {
            try {
                System.out.println("Ascensor en desplazamiento, espere");
                wait();
                tBajar(piso);
            } catch (InterruptedException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
