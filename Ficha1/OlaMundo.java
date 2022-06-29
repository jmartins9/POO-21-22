
public class OlaMundo {
    final double pi = 3.14; //final - constantes

    public static void main(String[] args) {
        String saudacao = geraSaudacao("Mundo");
        System.out.println(saudacao);
    }

    public static String geraSaudacao(String nome) {
        return "Olá " + nome + "!";
    }

}








