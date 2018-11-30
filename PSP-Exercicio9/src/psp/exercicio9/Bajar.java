package psp.exercicio9;

public class Bajar extends Thread implements Runnable {

    private Control con;
    private String piso;

    public Bajar(Control control, String piso) {
        con = control;
        this.piso = piso;
    }

    @Override
    public void run() {
        // Invocamos el metodo sincronizado de la clase carrera
        con.tBajar(piso);
    }
}
