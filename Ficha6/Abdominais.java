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


public class Abdominais extends Atividade {
    private String tipo;
    private int repeticoes;

    public Abdominais() {
        super();
        this.tipo = "";
        this.repeticoes = 0;
    }

    public Abdominais(String descricao, LocalDateTime data, int duracao, String tipo, int repeticoes) {
        super(descricao, data, duracao);
        this.tipo = tipo;
        this.repeticoes = repeticoes;
    }

    public Abdominais(Abdominais outro) {
        super(outro);
        this.tipo = outro.getTipo();
        this.repeticoes = outro.getRepeticoes();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }


    public double calculaCalorias() {
        return getDuracao() * repeticoes * 3 / 5;
    }


    public Atividade clone() {
        return new Abdominais(this);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Abdominais abdominal = (Abdominais) o;
        return getRepeticoes() == abdominal.getRepeticoes()
                && this.tipo.equals(abdominal.getTipo());
    }
}