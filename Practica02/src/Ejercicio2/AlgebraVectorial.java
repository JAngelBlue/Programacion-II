package Ejercicio2;

class AlgebraVectorial {

    private Vector a;
    private Vector b;

    // --- SOBRECARGA DE CONSTRUCTORES ---

    // Constructor 1: Sin argumentos (vectores por defecto en 0)
    public AlgebraVectorial() {
        this(new Vector(), new Vector());
    }

    // Constructor 2: Recibe objetos de tipo Vector
    public AlgebraVectorial(Vector a, Vector b) {
        this.a = a;
        this.b = b;
    }

    // Constructor 3: Recibe componentes 2D para ambos vectores (ax, ay, bx, by)
    public AlgebraVectorial(double ax, double ay, double bx, double by) {
        this(new Vector(ax, ay, 0.0), new Vector(bx, by, 0.0));
    }

    // Constructor 4: Recibe componentes 3D para ambos vectores (ax, ay, az, bx, by, bz)
    public AlgebraVectorial(double ax, double ay, double az, double bx, double by, double bz) {
        this(new Vector(ax, ay, az), new Vector(bx, by, bz));
    }

    // Métodos Getter y Setter
    public Vector getA() { return a; }
    public Vector getB() { return b; }
    public void setA(Vector a) { this.a = a; }
    public void setB(Vector b) { this.b = b; }

    // --- INCISOS DE PERPENDICULARIDAD (a - d) ---

    // a) Perpendicular: |a + b| = |a - b|
    public boolean esPerpendicularCriterioA() {
        double magSuma = a.sumar(b).magnitud();
        double magResta = a.restar(b).magnitud();
        return Math.abs(magSuma - magResta) < Vector.EPSILON;
    }

    // b) Perpendicular: |a - b| = |b - a| (Demostración de igualdad de magnitudes)
    public boolean esPerpendicularCriterioB() {
        double magAB = a.restar(b).magnitud();
        double magBA = b.restar(a).magnitud();
        return Math.abs(magAB - magBA) < Vector.EPSILON;
    }

    // c) Perpendicular: a · b = 0
    public boolean esPerpendicularCriterioC() {
        return Math.abs(a.productoEscalar(b)) < Vector.EPSILON;
    }

    // d) Perpendicular: |a + b|^2 = |a|^2 + |b|^2
    public boolean esPerpendicularCriterioD() {
        double lhs = a.sumar(b).magnitudCuadrada();
        double rhs = a.magnitudCuadrada() + b.magnitudCuadrada();
        return Math.abs(lhs - rhs) < Vector.EPSILON;
    }

    // SOBRECARGA DE MÉTODOS para Perpendicularidad por opción numérica
    public boolean esPerpendicular(int opcionCriterio) {
        switch (opcionCriterio) {
            case 1: return esPerpendicularCriterioA();
            case 2: return esPerpendicularCriterioB();
            case 3: return esPerpendicularCriterioC();
            case 4: return esPerpendicularCriterioD();
            default: return esPerpendicularCriterioC();
        }
    }

    // --- INCISOS DE PARALELISMO (e - f) ---

    // e) Paralela: a = r * b (comprueba si existe un escalar r)
    public boolean esParalelaCriterioE() {
        if (a.esNulo() || b.esNulo()) {
            return true; // El vector nulo es paralelo a cualquier vector
        }
        // Buscar la primera componente no nula de b para calcular el escalar r
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

    // f) Paralela: a x b = (0,0,0)
    public boolean esParalelaCriterioF() {
        Vector productoCruz = a.productoCruz(b);
        return productoCruz.esNulo();
    }

    // SOBRECARGA DE MÉTODOS para Paralelismo seleccionando el criterio mediante boolean
    public boolean esParalela(boolean usarProductoCruz) {
        if (usarProductoCruz) {
            return esParalelaCriterioF();
        } else {
            return esParalelaCriterioE();
        }
    }

    // --- INCISOS DE PROYECCIÓN Y COMPONENTE (g - h) ---

    // g) Proyección ortogonal de a sobre b: Proy_b a = ((a · b) / |b|^2) * b
    public Vector proyeccion_de_a_sobre_b() {
        if (b.esNulo()) {
            throw new ArithmeticException("No se puede proyectar sobre el vector nulo.");
        }
        double escalar = a.productoEscalar(b) / b.magnitudCuadrada();
        return b.multiplicarEscalar(escalar);
    }

    // h) Componente de a en la dirección de b: Comp_b a = (a · b) / |b|
    public double componente_de_a_en_b() {
        if (b.esNulo()) {
            throw new ArithmeticException("No se puede calcular el componente sobre el vector nulo.");
        }
        return a.productoEscalar(b) / b.magnitud();
    }
}

