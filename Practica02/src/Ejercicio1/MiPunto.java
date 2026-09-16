package Ejercicio1;

public class MiPunto {

    // a) Atributos x e y que representan las coordenadas
    // Se usan double para permitir coordenadas decimales como se pide en la prueba (10.0, 30.5)
    private double x;
    private double y;

    // b) Un constructor sin argumentos que crea un punto (0, 0)
    public MiPunto() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // c) Un constructor que construye un punto con las coordenadas especificadas
    public MiPunto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Métodos getter solicitados en el inciso a)
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

//     d) Metodo distancia que retorna la distancia desde este punto hasta un punto especificado del tipo MiPunto
    public double distancia(MiPunto otroPunto) {
        // La fórmula de la distancia entre dos puntos (x1, y1) y (x2, y2) es:
        // sqrt((x2 - x1)^2 + (y2 - y1)^2)
        double diffX = otroPunto.getX() - this.x;
        double diffY = otroPunto.getY() - this.y;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }

    // e) Metodo distancia que retorna la distancia desde este punto hasta otro punto con las coordenadas x e y especificadas
    public double distancia(double x, double y) {
        // Se reutiliza la lógica calculando la diferencia directamente con los parámetros
        double diffX = x - this.x;
        double diffY = y - this.y;
        return Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
    }
}
