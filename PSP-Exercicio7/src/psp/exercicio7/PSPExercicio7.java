package psp.exercicio7;



public class PSPExercicio7 {

    public static void main(String[] args) throws InterruptedException {


        Buzon buz = new Buzon();
        
       
        
        Enviar p1 = new Enviar(buz);
        Recibir p2 = new Recibir(buz);
        Enviar p3 = new Enviar(buz);
        Recibir p4 = new Recibir(buz);
        
        p1.start();
        p2.start();
        
        p4.start();
        p3.start();
        
   
    

    }

}
