
package psp.exercicio8;

public class PSPExercicio8 {

    public static void main(String[] args)  throws InterruptedException  {
       
        
        Carrera carrera = new Carrera();
        
        Lebre leb = new Lebre(carrera);
        Tartaruga tar = new Tartaruga(carrera);
        
        // Empezamos los hilos
        leb.start();
        tar.start();
        
    }
    
}
