import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Fitness fit = new Fitness();
        List<Atividade> ativs = new ArrayList<>();
        Utilizador u = new Utilizador();
        ativs.add(new Corrida("aaa", LocalDateTime.now(),5,10,3000,"riberia",u));

        Utilizador user1 = new Utilizador("1@gmail.com","123","Jao","Masc",178, LocalDate.of(2000,10,9),66,"",ativs);
        Utilizador user2 = user1.clone();
        user2.setEmail("2@gmail.com");
        Utilizador user3 = user1.clone();
        user3.setEmail("3@gmail.com");
        Utilizador user4 = user1.clone();
        user4.setEmail("4@gmail.com");
        Utilizador user5 = user1.clone();
        user5.setEmail("5@gmail.com");
        Utilizador user6 = user1.clone();
        user6.setEmail("6@gmail.com");

        fit.adicionaUser(user1);
        fit.adicionaUser(user2);
        fit.adicionaUser(user3);
        fit.adicionaUser(user4);
        fit.adicionaUser(user5);
        fit.adicionaUser(user6);

        System.out.println(fit.quantos());
        System.out.println(fit.tempoTotalUtilizador("1@gmail.com"));
        fit.actualizaDesportoFav();
        System.out.println(fit.toString());







    }




}
