package psp.exercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cajero {
    
    // valor base del dinero en el cajero
    Integer capital = 10;
    
    private int sigSumar = 0;
    private int sigRestar = 0;
    // Flags para saber el estado del buffer
    private boolean estaLlena = false;

    public synchronized void sumar() {
        
        // Bucle que tiene que hacer 10 ingresos
        while (sigSumar < 10) {
            try {
                // Ingresamos al capital una cantida al azar
                capital += (int) (Math.random() * 100 + 0);
                // Mostramos el capital
                System.out.println("Ingreso de capital " + capital + " " +sigSumar);
                // Para llevar un orden de cuando debe esperar y despertar al otro hilo, hago que espere en los num impares y para que en la última condición no se ponga a wait
                if (sigSumar % 2 == 1 && estaLlena == false) {
                    
                    // Llama a al otro hilo que está a la espera
                    notify();
                    // Pone a la espera este hilo
                    wait();
                }
                
                sigSumar++;

            } catch (InterruptedException ex) {
                Logger.getLogger(PSPExercicio6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void restar() {
        
        // Bucle que tiene que hacer 5 retiradas
        while (sigRestar < 5) {
            try {
                // Retiramos al capital una cantida al azar
                capital -= (int) (Math.random() * 100 + 0);
                // Mostramos el capital
                System.out.println("Reiterada de capital " + capital);
                // Para llevar un orden de cuando debe esperar y despertar al otro hilo, hago que espere en los num pares
                if (sigRestar % 2 == 0) {

                    notify();
                    wait();
                }
                sigRestar++;

            } catch (InterruptedException ex) {
                Logger.getLogger(PSPExercicio6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Cuando finaliza el bucle despierta al otro hilo y pone la variable a true
        notify();
        estaLlena = true;
    }
}
