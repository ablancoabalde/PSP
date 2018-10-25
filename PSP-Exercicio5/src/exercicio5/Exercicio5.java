
package exercicio5;

public class Exercicio5 {

    public static void main(String[] args) throws InterruptedException {
        Hilo1 h1 = new Hilo1("fio1");
        Hilo1 h2 = new Hilo1("fio2");
        
        // La prioridad no hace nada
        h1.setPriority(1);
        h2.setPriority(10);
        
        h2.start();
        h1.start();        
        
        // Tiempo para dormir
        h1.join(10);
       
        
        
    }
    
}
