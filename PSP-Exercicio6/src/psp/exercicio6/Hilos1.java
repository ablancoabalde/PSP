package psp.exercicio6;

public class Hilos1 extends Thread {

    private Cajero cajero;

    public Hilos1(Cajero cajero) {
        this.cajero = cajero;
    }

    @Override
    public void run() {

        cajero.sumar();
        
   

    }

}
