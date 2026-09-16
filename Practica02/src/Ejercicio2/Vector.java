package Ejercicio2;
import java.util.Objects;
//
// * Clase que representa un Vector tridimensional (3D) con sus operaciones algebraicas básicas.
//
class Vector {

    private double x;
    private double y;
    private double z;

    // Tolerancia para comparaciones numéricas en punto flotante (double)
    public static final double EPSILON = 1e-9;

    public Vector() {
        this(0.0, 0.0, 0.0);
    }

    public Vector(double x, double y) {
        this(x, y, 0.0);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Métodos Getter y Setter
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }

    // Suma de vectores: a + b
    public Vector sumar(Vector otro) {
        return new Vector(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }

    // Resta de vectores: a - b
    public Vector restar(Vector otro) {
        return new Vector(this.x - otro.x, this.y - otro.y, this.z - otro.z);
    }

    // Multiplicación por un escalar: r * a
    public Vector multiplicarEscalar(double r) {
        return new Vector(this.x * r, this.y * r, this.z * r);
    }

    // Producto escalar (Dot Product): a · b
    public double productoEscalar(Vector otro) {
        return (this.x * otro.x) + (this.y * otro.y) + (this.z * otro.z);
    }

    // Producto vectorial (Cross Product): a x b
    public Vector productoCruz(Vector otro) {
        double cx = this.y * otro.z - this.z * otro.y;
        double cy = this.z * otro.x - this.x * otro.z;
        double cz = this.x * otro.y - this.y * otro.x;
        return new Vector(cx, cy, cz);
    }

    // Magnitud o norma del vector: |a|
    public double magnitud() {
        return Math.sqrt(magnitudCuadrada());
    }

    // Cuadrado de la magnitud: |a|^2
    public double magnitudCuadrada() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }

    // Determina si el vector es el vector nulo (0,0,0)
    public boolean esNulo() {
        return magnitud() < EPSILON;
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}
