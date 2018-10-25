package exercicio4;

public class Impares extends Thread {

    int sumaImpares;

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 != 0) {
                sumaImpares += i;
            }
        }
        System.out.println("Suma Impares= " + sumaImpares);
    }
}
