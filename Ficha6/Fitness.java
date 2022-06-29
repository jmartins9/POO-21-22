import java.util.*;
import java.util.stream.Collectors;

public class Fitness {

    private Map<String,Utilizador> users;

    public Fitness() {
        this.users = new HashMap<>();
    }

    public Fitness(Fitness f) {
        this.users = f.getUsers();
    }

    public Map<String, Utilizador> getUsers() {
        return this.users.values().stream().collect(Collectors.toMap(Utilizador::getEmail,Utilizador::clone));
    }

    public void setUsers(Map<String, Utilizador> users) {
        this.users = users.values().stream().collect(Collectors.toMap(Utilizador::getEmail,Utilizador::clone));
    }

    public void adicionaUser(Utilizador user) {
        this.users.put(user.getEmail(), user.clone());
    }

    public boolean existeUtilizador(String email) {
        return this.users.containsKey(email);
    }

    public int quantos() {
        return this.users.size();
    }

    public int quantos(String actividade, String email) {
        Utilizador user = this.users.get(email);
        return (int) user.getAtividades().stream().filter(p -> actividade.equals(p.getClass().getName())).count();
    }

    public Utilizador getUtilizador(String email) {
        return this.users.get(email);
    }

    public void adiciona(String email, Atividade act) {
        this.users.get(email).getAtividades().add(act.clone());
    }

    public List<Atividade> getAllActividades() {
        List<Atividade> atividades = new ArrayList<>();
        Iterator<Utilizador> it = this.users.values().iterator();
        Utilizador ut;
        while(it.hasNext()) {
            ut = it.next();
            atividades.addAll(ut.getAtividades().stream().map(Atividade::clone).toList());
        }
        return atividades;
    }

    public void adiciona(String email, Set<Atividade> activs) {
        this.users.get(email).getAtividades().addAll(activs.stream().map(Atividade::clone).toList());
    }

    public int tempoTotalUtilizador(String email) {
        return this.users.get(email).getAtividades().stream().mapToInt(Atividade::getDuracao).sum();
    }

    public Atividade actividadeMaisExigente() {
        Iterator<Utilizador> it = this.users.values().iterator();
        Iterator<Atividade> aux;
        Atividade ativMax = null;
        Atividade ativ;
        int calorias= Integer.MAX_VALUE;
        while(it.hasNext()) {
            aux = it.next().getAtividades().iterator();
            while (aux.hasNext()) {
                ativ = aux.next();
                if (ativ.calculaCalorias()>calorias) {
                    ativMax = ativ;
                }
            }
        }
        return ativMax;
    }

    public Utilizador utilizadorMaisActivo() {
        Iterator<Utilizador> it = this.users.values().iterator();
        Utilizador ut;
        Utilizador utMax = null;
        int caloriasUt = Integer.MIN_VALUE;

        while (it.hasNext()) {
            ut = it.next();
            if (ut.getAtividades().stream().mapToDouble(Atividade::calculaCalorias).sum()>caloriasUt) {
                utMax = ut;
            }
        }
        return utMax;
    }

    public void actualizaDesportoFav() {
        int corrida=0;
        int canoagem=0;
        int abdominais=0;

        Iterator<Utilizador> itu = this.users.values().iterator();
        Utilizador ut;
        Iterator<Atividade> ita;
        Atividade aux;

        while (itu.hasNext()) {
            ut = itu.next();
            ita = ut.getAtividades().iterator();
            while(ita.hasNext()) {
                aux = ita.next();
                if (aux.getClass().getName().equals("Corrida")) corrida++;
                else if (aux.getClass().getName().equals("Canoagem")) canoagem++;
                else abdominais++;
            }
            if (corrida>canoagem && corrida>abdominais) ut.setDeportoFavorito("Corrida");
            else if (canoagem>corrida && canoagem>abdominais) ut.setDeportoFavorito("Canoagem");
            else ut.setDeportoFavorito("Abdominais");
            corrida = canoagem = abdominais = 0;
        }

    }

    public Set<Utilizador> ordenarUtilizadores() {
        return users.values().stream().map(Utilizador::clone).collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fitness{");
        sb.append("users=").append(users);
        sb.append('}');
        return sb.toString();
    }
}
