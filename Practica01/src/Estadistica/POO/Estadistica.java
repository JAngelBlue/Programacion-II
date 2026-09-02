public class Estadistica {
    private double[] numeros;

    public Estadistica(double[] numeros) {
        this.numeros = numeros;
    }

    public double promedio() {
        double sumaProm = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaProm = sumaProm + numeros[i];
        }
        return sumaProm / numeros.length;
    }
    public double desviacion(){
        double prom = promedio();
        double sumaDes=0;
        for (int j=0; j<numeros.length; j++){
            sumaDes= sumaDes + Math.pow((numeros[j]-prom),2);
        }
        return Math.sqrt((sumaDes)/(numeros.length-1));
    }
}
