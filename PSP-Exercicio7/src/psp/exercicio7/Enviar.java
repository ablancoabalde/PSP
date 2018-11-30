package psp.exercicio7;

import static psp.exercicio7.Buzon.mensaje;

public class Enviar extends Thread {

    private Buzon buzon;

    public Enviar(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {
        
      buzon.enviar();

    }

}
