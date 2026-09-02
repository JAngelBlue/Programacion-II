public class EcuacionCuadratica {
    private double a;
    private double b;
    private double c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminante(){
        return (this.b*this.b) - (4 * this.a * this.c);
    }
    public double getRaiz1(){
        return (- this.b + Math.sqrt((Math.pow(this.b, 2)) - (4 * this.a * this.c))) / (2 * this.a);
    }
    public double getRaiz2(){
        return (- this.b - Math.sqrt((Math.pow(this.b, 2)) - (4 * this.a * this.c))) / (2 * this.a);
    }

}
