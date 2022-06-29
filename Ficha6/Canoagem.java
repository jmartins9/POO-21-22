/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Canoagem extends Atividade{
    private String barco;
    private double vento;
    private double distancia;
    private int nvoltas;

    private Utilizador user;

    public Canoagem() {
        super();
        this.barco = "";
        this.vento = 0;
        this.distancia = 0;
        this.nvoltas = 0;
    }


    public Canoagem(String descricao, LocalDateTime data, int duracao, String barco, double vento, double distancia, int nvoltas, Utilizador user) {
        super(descricao, data, duracao);
        this.barco = barco;
        this.vento = vento;
        this.distancia = distancia;
        this.nvoltas = nvoltas;
        this.user = user;
    }

    public Canoagem(Canoagem outro) {
        super(outro);
        this.barco = outro.getBarco();
        this.vento = outro.getVento();
        this.distancia = outro.getDistancia();
        this.nvoltas = outro.getNvoltas();
    }


    public String getBarco() {
        return barco;
    }

    public void setBarco(String barco) {
        this.barco = barco;
    }

    public double getVento() {
        return vento;
    }

    public void setVento(double vento) {
        this.vento = vento;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getNvoltas() {
        return nvoltas;
    }

    public void setNvoltas(int nvoltas) {
        this.nvoltas = nvoltas;
    }

    public Utilizador getUser() {
        return user;
    }

    public void setUser(Utilizador user) {
        this.user = user;
    }

    @Override
    public double calculaCalorias() {
        long idade =  ChronoUnit.YEARS.between(LocalDate.now(),getUser().getdataNascimento());
        return distancia*vento*getDuracao()*idade/4;
    }

    @Override
    public Atividade clone() {
        return new Canoagem(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canoagem canoagem = (Canoagem) o;
        return Double.compare(canoagem.getVento(), getVento()) == 0 
               && Double.compare(canoagem.getDistancia(), getDistancia()) == 0 
               && getNvoltas() == canoagem.getNvoltas() 
               && this.barco.equals(canoagem.getBarco());
    }

    @Override
    public String toString() {
        return "Canoagem{" +
                super.toString() +
                "barco='" + barco + '\'' +
                ", vento=" + vento +
                ", distancia=" + distancia +
                ", nvoltas=" + nvoltas +
                '}';
    }
}
