import java.util.concurrent.TimeUnit;

public class Tempogasto {

    public long tempoGasto() {
        long tempoInicial = System.currentTimeMillis();
        Fatorial f = new Fatorial();
        f.factorial(500);
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal-tempoInicial;
    }
}
