package psp.exercicio8;

public class Carrera {

    // Variables con las posiciones iniciales
    private int posL = 1;
    private int posT = 1;

    // Condición de para que haga el bucle hasta que gane 1
    private boolean vMeta = false;
    // Nombres
    String nLebre = "Lebre";
    String nTar = "Tartaruga";

    public synchronized void tLebre() throws InterruptedException {

        while (vMeta != true) {
            // Genera y almacena un número de un metodo
            int rNum = azar();
            // Condiciones para aumentar o disminuir posición
            if (rNum >= 1 && rNum <= 20) {
                // Muestra la posición
                muestraPos(posL, nLebre);
            } else if (rNum > 20 && rNum <= 40) {
                posL += 9;
                // Comprueba si ya se llego a la meta
                meta(posT, nLebre);

            } else if (rNum > 40 && rNum <= 50) {
                posL -= 12;
                // Comprueba que si la posición es menor que 1, devuelve el valor 1
                posL = posInferioaInicial(posL);
                muestraPos(posL, nLebre);

            } else if (rNum > 50 && rNum <= 80) {
                posL += 1;
                meta(posL, nLebre);

            } else {
                posL -= 2;
                posL = posInferioaInicial(posL);
                muestraPos(posL, nLebre);

            }

            notify();
            wait();

        }
        notify();
    }

    public synchronized void tTartaruga() throws InterruptedException {

        while (vMeta != true) {
            // Genera y almacena un número de un metodo
            int rNum = azar();
            // Condiciones para aumentar o disminuir posición
            if (rNum >= 1 && rNum <= 50) {
                posT += 3;
                // Comprueba si ya se llego a la meta
                meta(posT, nTar);

            } else if (rNum > 50 && rNum <= 70) {
                posT -= 6;
                // Comprueba que si la posición es menor que 1, devuelve el valor 1
                posT = posInferioaInicial(posT);
                // Muestra la posición
                muestraPos(posT, nTar);

            } else {
                posT += 1;
                meta(posT, nTar);

            }
            notify();
            wait();

        }
        notify();
    }

    /**
     * Metodo que genera un numero al azar comprendido entre 1 y 100 y devuelve
     * un entero
     *
     * @return int
     */
    public int azar() {

        return (int) (Math.random() * 100 + 1);
    }

    /**
     * Comprueba que la posición no sea inferior a 1 si es así lo sustituye por
     * 1, si no, devuelve la posición recogida
     *
     * @param pos
     * @return int
     */
    private int posInferioaInicial(int pos) {
        if (pos < 1) {
            return 1;
        } else {
            return pos;
        }
    }

    /**
     * Comprueba si alguno de los 2 animales ha llegado a la meta recibe tanto
     * la posición como el nombre, si no, llama al metodo para mostrar la
     * posicion
     *
     * @param pos
     * @param nome
     */
    private void meta(int pos, String nome) {
        if (pos >= 70) {
            vMeta = true;
            muestraPos(pos, nome);
            System.out.println("GANO " + nome);
        } else {
            muestraPos(pos, nome);
        }
    }

    /**
     * Muestra la posición y el nombre que recibe pos pantalla.
     *
     * @param pos
     * @param nome
     */
    private void muestraPos(int pos, String nome) {
        System.out.println("Posición " + pos + " " + nome);
    }

}
