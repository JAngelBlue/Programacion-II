package Ejercicio2;
import java.util.Objects;
class Vector {

    private double x;
    private double y;
    private double z;
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
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setZ(double z) { this.z = z; }
    public Vector sumar(Vector otro) {
        return new Vector(this.x + otro.x, this.y + otro.y, this.z + otro.z);
    }
    public Vector restar(Vector otro) {
        return new Vector(this.x - otro.x, this.y - otro.y, this.z - otro.z);
    }
    public Vector multiplicarEscalar(double r) {
        return new Vector(this.x * r, this.y * r, this.z * r);
    }
    public double productoEscalar(Vector otro) {
        return (this.x * otro.x) + (this.y * otro.y) + (this.z * otro.z);
    }
    public Vector productoCruz(Vector otro) {
        double cx = this.y * otro.z - this.z * otro.y;
        double cy = this.z * otro.x - this.x * otro.z;
        double cz = this.x * otro.y - this.y * otro.x;
        return new Vector(cx, cy, cz);
    }
    public double magnitud() {
        return Math.sqrt(magnitudCuadrada());
    }
    public double magnitudCuadrada() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }
    public boolean esNulo() {
        return magnitud() < EPSILON;
    }
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
}
