package psp.exercicio6;

public class Hilos2 extends Thread {

    private Cajero cajero;

    public Hilos2(Cajero cajero) {
        this.cajero = cajero;
    }

    @Override
    public void run() {

        cajero.restar();
        

    }
}
