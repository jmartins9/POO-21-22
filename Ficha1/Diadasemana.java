import java.time.LocalDate;
import java.util.Scanner;

public class Diadasemana {

    public static void main(String[] args) {
        diasemana();
    }

    public static void diasemana() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira dia,mes e ano");
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();

        int dias = (ano-1900)*365;
        dias = dias + (ano-1900)/4;

        LocalDate date = LocalDate.of(ano,mes,dia);
        boolean bissexto = date.isLeapYear();

        if (bissexto && (mes==1 || mes ==2)) {
            dias-=1;
        }

        dias += date.getDayOfYear();

        dias = dias%7;

        switch (dias) {
            case 0 : System.out.println("O dia da semana é Domingo"); break;
            case 1 : System.out.println("O dia da semana é Segunda"); break;
            case 2 : System.out.println("O dia da semana é Terça"); break;
            case 3 : System.out.println("O dia da semana é Quarta"); break;
            case 4 : System.out.println("O dia da semana é Quinta"); break;
            case 5 : System.out.println("O dia da semana é Sexta"); break;
            case 6 : System.out.println("O dia da semana é Sábado"); break;
            default : System.out.println("Algo correu mal"); break;
        }
    }
}
