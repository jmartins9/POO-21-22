import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Somadatas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira primeira data:");
        int dia = sc.nextInt();
        int hora = sc.nextInt();
        int minuto = sc.nextInt();
        int segundo = sc.nextInt();
        LocalDateTime date = LocalDateTime.of(0,0,dia,hora,minuto,segundo);
        System.out.println("Insira segunda data:");
        int dia1 = sc.nextInt();
        int hora1 = sc.nextInt();
        int minuto1 = sc.nextInt();
        int segundo1 = sc.nextInt();
        LocalDateTime date1 = LocalDateTime.of(0,0,dia,hora,minuto,segundo);
        somadatas(date,date1);
    }

    public static String somadatas (LocalDateTime date, LocalDateTime date1) {
        date = date.plusSeconds(date1.getSecond());
        date = date.plusMinutes(date1.getMinute());
        date = date.plusHours(date1.getHour());
        date = date.plusDays(date1.getDayOfMonth());


        return "";
    }
}
