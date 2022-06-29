import java.time.LocalDateTime;

public abstract class Atividade {

    private static int nextCod=1;
    private int cod;
    private String descricao;
    private LocalDateTime date;
    private int duracao;

    public abstract double calculaCalorias();

    public Atividade() {
        this.cod = nextCod;
        nextCod++;
        this.descricao = "";
        this.date = LocalDateTime.now();
        this.duracao = 0;
    }

    public Atividade(String descricao, LocalDateTime date, int duracao) {
        this.cod = nextCod;
        nextCod++;
        this.descricao = descricao;
        this.date = date;
        this.duracao = duracao;
    }

    public Atividade(Atividade ativ) {
        this.cod = ativ.getCod();
        this.duracao = ativ.getDuracao();
        this.descricao = ativ.getDescricao();
        this.date = ativ.getDate();
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return  getCod() == atividade.getCod() &&
                getDuracao() == atividade.getDuracao() &&
                getDescricao().equals(atividade.getDescricao()) &&
                getDate().isEqual(atividade.getDate());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atividade {");
        sb.append("cod=").append(cod);
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", date=").append(date);
        sb.append(", duracao=").append(duracao);
        sb.append('}');
        return sb.toString();
    }

    public abstract Atividade clone();

}
