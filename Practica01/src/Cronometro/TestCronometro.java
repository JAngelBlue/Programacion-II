import java.util.Scanner;

public class TestCronometro {
    // Cantidad de numeros que se ordenara
    static int n = 100000;
    // Se define un array que servira para almacenar los n numeros
    static int[] numeros = new int[n];

    public static void main(String[] args) {
        // Llamamos al algoritmo para cargar numeros en el array
        llenarNumeros();

        // Instanciando la clase Cronometro
        Cronometro cronometro = new Cronometro();

        System.out.println("Ordenando " + n + " números...");

        // Iniciamos el cronometro
        cronometro.inicia();

        // Llamamos a la funcion de ordenacion por seleccion
        ordenacionPorSeleccion();

        // Finalizamos el cronometro
        cronometro.detener();

        System.out.println("Hora inicio: " + cronometro.getInicio());
        System.out.println("Hora fin: " + cronometro.getFinaliza());

        // Llamamos a la funcion que calcula el lapso de tiempo
        long lapso = cronometro.lapsoDeTiempo();
        System.out.println("Pasaron " + lapso + " milisegundos" );
    }

    private static void llenarNumeros() {
        // Llena el array con n numeros aleatorios
        for (int i = 0; i < n; i++) {
            numeros[i] = (int) (Math.random() * 1000000);
        }
    }

    private static void ordenacionPorSeleccion() {
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            // Intercambiar el menor con el primer elemento no ordenado
            int aux = numeros[indiceMinimo];
            numeros[indiceMinimo] = numeros[i];
            numeros[i] = aux;
        }
    }
}