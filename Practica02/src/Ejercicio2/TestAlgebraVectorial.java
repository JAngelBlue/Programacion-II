package Ejercicio2;
public class TestAlgebraVectorial {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("      DEMOSTRACIÓN DE ÁLGEBRA VECTORIAL EN JAVA   ");
        System.out.println("=================================================\n");
        System.out.println("--- 1. PRUEBA DE VECTORES PERPENDICULARES ---");
        Vector v1 = new Vector(3, 0, 0);
        Vector v2 = new Vector(0, 4, 0);
        AlgebraVectorial algebraPerp = new AlgebraVectorial(v1, v2);
        System.out.println("Vector a = " + v1);
        System.out.println("Vector b = " + v2);
        System.out.println("a) |a + b| = |a - b|              -> ¿Perpendicular? " + algebraPerp.esPerpendicularCriterioA());
        System.out.println("b) |a - b| = |b - a|              -> Verificación:   " + algebraPerp.esPerpendicularCriterioB());
        System.out.println("c) a · b = 0                       -> ¿Perpendicular? " + algebraPerp.esPerpendicularCriterioC());
        System.out.println("d) |a + b|^2 = |a|^2 + |b|^2       -> ¿Perpendicular? " + algebraPerp.esPerpendicularCriterioD());
        System.out.println("\n--- 2. PRUEBA DE VECTORES PARALELOS ---");
        Vector v3 = new Vector(1, 2, 3);
        Vector v4 = new Vector(2, 4, 6);
        AlgebraVectorial algebraPara = new AlgebraVectorial(v3, v4);
        System.out.println("Vector a = " + v3);
        System.out.println("Vector b = " + v4);
        System.out.println("e) a = r * b                       -> ¿Paralelo? " + algebraPara.esParalelaCriterioE());
        System.out.println("f) a x b = (0,0,0)                 -> ¿Paralelo? " + algebraPara.esParalelaCriterioF());
        System.out.println("\n--- 3. PRUEBA DE PROYECCIÓN Y COMPONENTE ---");
        Vector v5 = new Vector(3, 4, 0);
        Vector v6 = new Vector(5, 0, 0);
        AlgebraVectorial algebraProy = new AlgebraVectorial(v5, v6);
        System.out.println("Vector a = " + v5);
        System.out.println("Vector b = " + v6);
        System.out.println("g) Proyección de a sobre b (Proy_b a) = " + algebraProy.proyeccion_de_a_sobre_b());
        System.out.println("h) Componente de a en b (Comp_b a)    = " + algebraProy.componente_de_a_en_b());
        System.out.println("\n--- 4. DEMOSTRACIÓN DE SOBRECARGA ---");
        AlgebraVectorial algebraDirecta = new AlgebraVectorial(1, 0, 0, 0, 1, 0);
        System.out.println("Instancia creada pasando componentes numéricas (1,0,0) y (0,1,0):");
        System.out.println("¿Es perpendicular (método sobrecargado opción 3)? " + algebraDirecta.esPerpendicular(3));
        System.out.println("¿Es paralela (método sobrecargado con boolean)?  " + algebraDirecta.esParalela(true));
    }
}
