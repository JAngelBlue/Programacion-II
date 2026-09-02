import java.util.Scanner;
public class TestEstadistica {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[] numeros = new double[10];
        System.out.println("Ingrese 10 numeros: ");
        for(int i=0; i<10; i++){
            System.out.println("Ingrse el numero "+(i+1));
            numeros[i] = sc.nextDouble();
        }
        Estadistica Ej = new Estadistica(numeros);
        System.out.println("El promedio es: "+ Ej.promedio()+" La desviacion es: "+ Ej.desviacion());
    }

}
