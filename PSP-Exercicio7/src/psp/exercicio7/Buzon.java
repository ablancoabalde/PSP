package psp.exercicio7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buzon {

    // variable para saber si está el buzón lleno
    private Boolean buzonLLeno = false;
    public static String mensaje = null;

    public synchronized void leer() {

        // Si el buzón esta lleno lee el mensaje y notifica a algún hilo que esté a esperar, si no muestra que no hay mensajes y lo pone a esperar
        if (buzonLLeno == true) {
            System.out.println(mensaje);
            mensaje = null;
            buzonLLeno = false;
            notify();
        } else {
            try {
                System.out.println("No hay mensaje para leer");

                // Pone a la espera este hilo
                wait();

                this.leer();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public synchronized void enviar() {

        // Si el buzón no esta lleno envia el mensaje y notifica a algún hilo que esté a esperar, si no muestra que el buzon está lleno y lo pone a esperar
        if (buzonLLeno == false) {
            System.out.println("mensaje enviado");
            this.mensaje = "hola";
            buzonLLeno = true;

            notify();
        } else {
            try {
                System.out.println("Mensaje no enviado, buzon lleno");

                // Pone a la espera este hilo
                wait();
//              
                this.enviar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
