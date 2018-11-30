package psp.exercicio7;

public class Recibir extends Thread {

    private Buzon buzon;

    public Recibir(Buzon buzon) {
        this.buzon = buzon;
    }

    @Override
    public void run() {

        buzon.leer();

    }
}
