import java.time.LocalTime;
import java.time.Duration;

public class Cronometro {
    private LocalTime inicio;
    private LocalTime finaliza;

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFinaliza() {
        return finaliza;
    }

    public Cronometro() {
    }

    public void inicia() {
        inicio = LocalTime.now();
    }

    public void detener() {
        finaliza = LocalTime.now();
    }

    public long lapsoDeTiempo() {
        Duration duracion = Duration.between(inicio, finaliza);
        int resultado = 0;
        resultado = segundosAMilisegundos(minutosASegundos(horasAMinutos(duracion.toHoursPart())));
        resultado = resultado + segundosAMilisegundos(minutosASegundos(duracion.toMinutesPart()));
        resultado = resultado + segundosAMilisegundos(duracion.toSecondsPart());
        resultado = resultado + duracion.toMillisPart();
        return resultado;
    }

    private int horasAMinutos(int horas) {
        return horas * 60;
    }

    private int minutosASegundos(int minutos) {
        return minutos * 60;
    }

    private int segundosAMilisegundos(int segundos) {
        return segundos * 1000;
    }
}