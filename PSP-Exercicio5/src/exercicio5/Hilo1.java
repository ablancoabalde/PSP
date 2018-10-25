package exercicio5;

public class Hilo1 extends Thread {

    String nombre;

    public Hilo1(String rNombre) {
        nombre = rNombre;

    }

    @Override
    public void run() {
        
        
        System.out.println("Ola, son o " + nombre);

    }

}
