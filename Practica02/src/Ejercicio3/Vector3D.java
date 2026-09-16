package Ejercicio3;

public class Vector3D {
    private double a1;
    private double a2;
    private double a3;

    // Sobrecarga de constructores
    public Vector3D() {
        this(0.0, 0.0, 0.0);
    }

    public Vector3D(double a1, double a2, double a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    // Getters y Setters
    public double getA1() { return a1; }
    public void setA1(double a1) { this.a1 = a1; }

    public double getA2() { return a2; }
    public void setA2(double a2) { this.a2 = a2; }

    public double getA3() { return a3; }
    public void setA3(double a3) { this.a3 = a3; }

    // a) Suma de dos vectores: c = a + b
    public Vector3D sumar(Vector3D b) {
        return new Vector3D(this.a1 + b.a1, this.a2 + b.a2, this.a3 + b.a3);
    }

    // b) Multiplicación de un escalar r por un vector a: b = r * a
    public Vector3D multiplicar(double r) {
        return new Vector3D(r * this.a1, r * this.a2, r * this.a3);
    }

    // c) Longitud de un vector a: |a| = sqrt(a1^2 + a2^2 + a3^2)
    public double longitud() {
        return Math.sqrt(a1 * a1 + a2 * a2 + a3 * a3);
    }

    // d) Normal de un vector a: b = a / |a|
    public Vector3D normal() {
        double mag = longitud();
        if (mag == 0) {
            throw new ArithmeticException("No se puede normalizar el vector nulo.");
        }
        return new Vector3D(a1 / mag, a2 / mag, a3 / mag);
    }

    // e) Producto escalar de a y b: a . b = a1*b1 + a2*b2 + a3*b3
    public double productoEscalar(Vector3D b) {
        return (this.a1 * b.a1) + (this.a2 * b.a2) + (this.a3 * b.a3);
    }

    // f) Producto vectorial de a y b: a x b
    public Vector3D productoVectorial(Vector3D b) {
        double c1 = this.a2 * b.a3 - this.a3 * b.a2;
        double c2 = this.a3 * b.a1 - this.a1 * b.a3;
        double c3 = this.a1 * b.a2 - this.a2 * b.a1;
        return new Vector3D(c1, c2, c3);
    }
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", a1, a2, a3);
    }
}