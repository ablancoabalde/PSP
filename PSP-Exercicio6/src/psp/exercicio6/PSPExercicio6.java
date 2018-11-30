package psp.exercicio6;

public class PSPExercicio6 {

    public static void main(String[] args) throws InterruptedException {
        
        Cajero caj = new Cajero();
           
        // creamos los hilos el de sumar y el de restar
        Hilos1 sumar = new Hilos1(caj);
        Hilos2 restar = new Hilos2(caj);
        
        sumar.start();
        restar.start();

    }
}
