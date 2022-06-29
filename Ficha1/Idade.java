import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Idade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ano = sc.nextInt();
        int mes = sc.nextInt();
        int dia = sc.nextInt();

        LocalDateTime agora = LocalDateTime.now();
        int a = agora.getYear();

        int dias = (a-ano)*365;
        dias = dias + (a-ano)/4;

        LocalDate date = LocalDate.of(ano,mes,dia);
        boolean bissexto = date.isLeapYear();

        if (bissexto && (mes==1 || mes ==2)) {
            dias-=1;
        }

        dias += date.getDayOfYear();

        dias *=24;


        System.out.println("A sua idade atual em horas é: " + dias);
        System.out.println("Data e hora do cálculo: " + agora);
    }
}
