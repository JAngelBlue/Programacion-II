package Ejercicio3;

public class TestVector3D {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("     PRUEBA DE ÁLGEBRA VECTORIAL 3D     ");
        System.out.println("=========================================\n");

        Vector3D a = new Vector3D(3.0, 4.0, 0.0);
        Vector3D b = new Vector3D(1.0, 2.0, 2.0);

        System.out.println("Vector a = " + a);
        System.out.println("Vector b = " + b);
        System.out.println("-----------------------------------------");

        // a) Suma
        Vector3D suma = a.sumar(b);
        System.out.println("a) Suma (a + b)            = " + suma);

        // b) Escalar * Vector
        double r = 2.5;
        Vector3D porEscalar = a.multiplicar(r);
        System.out.println("b) Escalar (r=" + r + " * a)     = " + porEscalar);

        // c) Longitud / Magnitud
        System.out.println("c) Longitud |a|            = " + a.longitud());

        // d) Vector Normal
        System.out.println("d) Normal de a (a / |a|)   = " + a.normal());

        // e) Producto Escalar
        System.out.println("e) Producto escalar (a · b)= " + a.productoEscalar(b));

        // f) Producto Vectorial
        System.out.println("f) Producto cruz (a x b)   = " + a.productoVectorial(b));
    }
}