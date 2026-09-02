import java.util.Scanner;

public class EstadisticaModularEstructurada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble();
        }
        double prom = promedio(numeros);
        double desv = desviacion(numeros, prom);
        System.out.println("El promedio es: " + prom);
        System.out.println("La desviación estándar es: " + desv);
    }
    public static double promedio(double[] valores) {
        double sumaProm = 0;
        for (int i = 0; i < valores.length; i++) {
            sumaProm = sumaProm + valores[i];
        }
        return sumaProm / valores.length;
    }
    public static double desviacion(double[] valores, double prom) {
        double sumaDes = 0;
        for (int j = 0; j < valores.length; j++) {
            sumaDes = sumaDes + Math.pow((valores[j] - prom), 2);
        }
        return Math.sqrt(sumaDes / (valores.length - 1));
    }
}
