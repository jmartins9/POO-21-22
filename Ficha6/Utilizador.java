import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utilizador implements Comparable<Utilizador> {

    private String email;
    private String password;
    private String nome;
    private String genero;
    private int altura;
    private LocalDate dataNascimento;
    private int peso;
    private String deportoFavorito;
    private List<Atividade> atividades;

    public Utilizador() {
        this.email = "";
        this.password = "";
        this.nome = "";
        this.genero = "";
        this.altura = 0;
        this.dataNascimento = LocalDate.now();
        this.peso = 0;
        this.deportoFavorito = "";
        this.atividades = new ArrayList<>();
    }

    public Utilizador(String email, String password, String nome, String genero, int altura, LocalDate dataNascimento, int peso, String deportoFavorito, List<Atividade> ativs) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.deportoFavorito = deportoFavorito;
        this.atividades = ativs;
    }

    private Utilizador(Utilizador user){
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nome = user.getNome();
        this.genero = user.getGenero();
        this.altura = user.getAltura();
        this.dataNascimento = user.getdataNascimento();
        this.peso = user.getPeso();
        this.deportoFavorito = user.getDeportoFavorito();
        this.atividades = user.getAtividades();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getDeportoFavorito() {
        return deportoFavorito;
    }

    public void setDeportoFavorito(String deportoFavorito) {
        this.deportoFavorito = deportoFavorito;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Atividade> getAtividades() {
        return this.atividades.stream().map(Atividade::clone).collect(Collectors.toList());
    }

    public void setAtividades(List<Atividade> atividade) {
        this.atividades = atividade.stream().map(Atividade::clone).collect(Collectors.toList());
    }

    public int compareTo (Utilizador u) {
        int r;
        if (this.atividades.stream().mapToDouble(Atividade::calculaCalorias).sum()>u.atividades.stream().mapToDouble(Atividade::calculaCalorias).sum()) r=1;
        else if (this.atividades.stream().mapToDouble(Atividade::calculaCalorias).sum()==u.atividades.stream().mapToDouble(Atividade::calculaCalorias).sum()) r = 0;
        else r=-1;
        return r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return getAltura() == that.getAltura() &&
               getPeso() == that.getPeso() &&
               getEmail().equals(that.getEmail()) &&
               getPassword().equals(that.getPassword()) &&
               getNome().equals(that.getNome()) &&
               getGenero().equals(that.getGenero()) &&
               getdataNascimento() == that.getdataNascimento() &&
               getDeportoFavorito().equals(that.getDeportoFavorito()) &&
               getAtividades().equals(that.getAtividades());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilizador{");
        sb.append("email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", altura=").append(altura);
        sb.append(", dataNascimento=").append(dataNascimento);
        sb.append(", peso=").append(peso);
        sb.append(", deportoFavorito='").append(deportoFavorito).append('\'');
        sb.append(", atividades=").append(atividades);
        sb.append('}');
        return sb.toString();
    }

    public Utilizador clone() {
        return new Utilizador(this);
    }
}
