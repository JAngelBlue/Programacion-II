import java.util.Scanner;
public class TestEcuacionLineal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese a");
        double a = sc.nextDouble();
        System.out.println("Ingrese b");
        double b = sc.nextDouble();
        System.out.println("Ingrese c");
        double c = sc.nextDouble();
        System.out.println("Ingrese d");
        double d = sc.nextDouble();
        System.out.println("Ingrese e");
        double e = sc.nextDouble();
        System.out.println("Ingrese f");
        double f = sc.nextDouble();

        EcuacionLineal ecuacion = new EcuacionLineal(a, b, c, d, e, f);
        if (ecuacion.tieneSolucion()){
            System.out.println("x es: "+ ecuacion.getX()+ "  Y es: " + ecuacion.getY());
        }else{
            System.out.println("La ecuacion no tiene solucion");
        }
    }
}