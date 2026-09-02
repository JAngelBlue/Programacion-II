import java.util.Scanner;
public class TestEcuacionCuadratica {
    static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese a: ");
        double a = sc.nextDouble();
        System.out.println("Ingrese b: ");
        double b = sc.nextDouble();
        System.out.println("Ingrese c: ");
        double c = sc.nextDouble();

        EcuacionCuadratica ejemplo = new EcuacionCuadratica(a, b, c);
        double dis = ejemplo.getDiscriminante();

        if(dis>0){
            System.out.println("Tiene dos soluciones que son: R1="+ejemplo.getRaiz1()+" R2="+ejemplo.getRaiz2());
        } else if (dis == 0) {
            System.out.println("Solo tiene una solucion que es R="+ejemplo.getRaiz2());
        }else{
            System.out.println("No tiene ninguna solucion");
        }

    }
}
