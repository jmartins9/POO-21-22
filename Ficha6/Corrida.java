import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Corrida extends Atividade {

    private double distancia;
    private double altimetria;
    private String percurso;

    private Utilizador user;

    public Corrida() {
        super();
        this.altimetria = 0;
        this.distancia = 0;
        this.percurso = "";
    }

    public Corrida(String descricao, LocalDateTime date, int duracao, double distancia, double altimetria, String percurso, Utilizador u) {
        super(descricao, date, duracao);
        this.distancia = distancia;
        this.altimetria = altimetria;
        this.percurso = percurso;
        this.user = u;
    }

    public Corrida(Corrida c) {
        super(c);
        this.distancia = c.getDistancia();
        this.altimetria = c.getAltimetria();
        this.percurso = c.getPercurso();
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAltimetria() {
        return altimetria;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    public String getPercurso() {
        return percurso;
    }

    public void setPercurso(String percurso) {
        this.percurso = percurso;
    }

    public Utilizador getUser() {
        return user;
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Corrida corrida = (Corrida) o;
        return this.getDistancia() == corrida.getDistancia() &&
               this.getAltimetria() == corrida.getAltimetria() &&
               this.getPercurso().equals(corrida.getPercurso());
    }

    public Atividade clone () {
        return new Corrida(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Corrida{");
        sb.append(super.toString());
        sb.append("distancia=").append(distancia);
        sb.append(", altimetria=").append(altimetria);
        sb.append(", percurso='").append(percurso).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public double calculaCalorias() {
        long idade = ChronoUnit.YEARS.between(this.user.getdataNascimento(),LocalDate.now());
        return this.distancia*this.user.getPeso()*this.getDuracao()*idade/50;
    }




}
