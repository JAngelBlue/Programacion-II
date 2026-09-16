package Ejercicio1;

public class MiPunto {
    private double x;
    private double y;
    public MiPunto() {
        this.x = 0.0;
        this.y = 0.0;
    }
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    public double distancia(MiPunto otroPunto) {
        double diffX = otroPunto.getX() - this.x;
        double diffY = otroPunto.getY() - this.y;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }
    public double distancia(double x, double y) {
        double diffX = x - this.x;
        double diffY = y - this.y;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }
}
