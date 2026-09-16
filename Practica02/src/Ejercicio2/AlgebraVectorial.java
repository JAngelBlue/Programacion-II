package Ejercicio2;

class AlgebraVectorial {

    private Vector a;
    private Vector b;
    public AlgebraVectorial() {
        this(new Vector(), new Vector());
    }
    public AlgebraVectorial(Vector a, Vector b) {
        this.a = a;
        this.b = b;
    }
    public AlgebraVectorial(double ax, double ay, double bx, double by) {
        this(new Vector(ax, ay, 0.0), new Vector(bx, by, 0.0));
    }
    public AlgebraVectorial(double ax, double ay, double az, double bx, double by, double bz) {
        this(new Vector(ax, ay, az), new Vector(bx, by, bz));
    }
    public Vector getA() { return a; }
    public Vector getB() { return b; }
    public void setA(Vector a) { this.a = a; }
    public void setB(Vector b) { this.b = b; }
    public boolean esPerpendicularCriterioA() {
        double magSuma = a.sumar(b).magnitud();
        double magResta = a.restar(b).magnitud();
        return Math.abs(magSuma - magResta) < Vector.EPSILON;
    }
    public boolean esPerpendicularCriterioB() {
        double magAB = a.restar(b).magnitud();
        double magBA = b.restar(a).magnitud();
        return Math.abs(magAB - magBA) < Vector.EPSILON;
    }
    public boolean esPerpendicularCriterioC() {
        return Math.abs(a.productoEscalar(b)) < Vector.EPSILON;
    }
    public boolean esPerpendicularCriterioD() {
        double lhs = a.sumar(b).magnitudCuadrada();
        double rhs = a.magnitudCuadrada() + b.magnitudCuadrada();
        return Math.abs(lhs - rhs) < Vector.EPSILON;
    }
    public boolean esPerpendicular(int opcionCriterio) {
        switch (opcionCriterio) {
            case 1: return esPerpendicularCriterioA();
            case 2: return esPerpendicularCriterioB();
            case 3: return esPerpendicularCriterioC();
            case 4: return esPerpendicularCriterioD();
            default: return esPerpendicularCriterioC();
        }
    }
    public boolean esParalelaCriterioE() {
        if (a.esNulo() || b.esNulo()) {
            return true;
        }
        double r = 0.0;
        if (Math.abs(b.getX()) > Vector.EPSILON) {
            r = a.getX() / b.getX();
        } else if (Math.abs(b.getY()) > Vector.EPSILON) {
            r = a.getY() / b.getY();
        } else if (Math.abs(b.getZ()) > Vector.EPSILON) {
            r = a.getZ() / b.getZ();
        }

        Vector rb = b.multiplicarEscalar(r);
        return a.restar(rb).esNulo();
    }
    public boolean esParalelaCriterioF() {
        Vector productoCruz = a.productoCruz(b);
        return productoCruz.esNulo();
    }
    public boolean esParalela(boolean usarProductoCruz) {
        if (usarProductoCruz) {
            return esParalelaCriterioF();
        } else {
            return esParalelaCriterioE();
        }
    }
    public Vector proyeccion_de_a_sobre_b() {
        if (b.esNulo()) {
            throw new ArithmeticException("No se puede proyectar sobre el vector nulo.");
        }
        double escalar = a.productoEscalar(b) / b.magnitudCuadrada();
        return b.multiplicarEscalar(escalar);
    }
    public double componente_de_a_en_b() {
        if (b.esNulo()) {
            throw new ArithmeticException("No se puede calcular el componente sobre el vector nulo.");
        }
        return a.productoEscalar(b) / b.magnitud();
    }
}

