package psp.exercicio9;

public class Subir extends Thread implements Runnable {

    private Control con;
    private String piso;

    public Subir(Control control, String piso) {
        con = control;
        this.piso = piso;
    }

    @Override
    public void run() {
        // Invocamos el metodo sincronizado de la clase carrera
        con.tSubir(piso);

    }
}
