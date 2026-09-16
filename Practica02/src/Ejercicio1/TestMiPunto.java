package Ejercicio1;

public class TestMiPunto {
    public static void main(String[] args) {
        System.out.println("--- Programa de Prueba para la clase MiPunto ---");
        MiPunto p1 = new MiPunto();
        MiPunto p2 = new MiPunto(10.0, 30.5);
        System.out.println("\nPunto 1 creado en las coordenadas: (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("Punto 2 creado en las coordenadas: (" + p2.getX() + ", " + p2.getY() + ")");
        double dist1 = p1.distancia(p2);
        System.out.println("\nDistancia desde Punto 1 hasta Punto 2 (usando objeto): " + dist1);
        double dist2 = p1.distancia(10.0, 30.5);
        System.out.println("Distancia desde Punto 1 hasta las coordenadas (10.0, 30.5) (usando coordenadas): " + dist2);
        System.out.println("\n(Ambos resultados deberían ser iguales)");
    }
}
