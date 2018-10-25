package exercicio4;

public class Pares extends Thread {

    int sumaPares;

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            }
        }
        System.out.println("Suma Pares= " + sumaPares);
    }

}
