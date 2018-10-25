package exercicio4;

public class Valores extends Thread {

    int sumaValores;

    @Override
    public void run() {

        for (int i = 1; i < 1000; i++) {
            if (i % 10 == 2 || i % 10 == 3) {

                sumaValores += i;
            }
        }
        System.out.println("Suma acabados en 2 y 3= " + sumaValores);

    }

}
