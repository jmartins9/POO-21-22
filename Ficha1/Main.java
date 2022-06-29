import java.util.Scanner;

public class Main {
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza temperatura em celsius para conversão:");
        double temp = sc.nextDouble();
        Temperatura t = new Temperatura();
        temp = t.celsiusParaFarenheit(temp);
        System.out.println("Temperatura em Farenheit: " + temp);
    }
    */

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza dois números para descobrir o máximo:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Max m = new Max();
        a = m.maximoNumeros(a,b);
        System.out.println("O máximo é: " + a);
    }
    */
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza nome da conta:");
        String str = sc.nextLine();
        System.out.println("Introduza saldo da conta:");
        int s = sc.nextInt();
        Descricao d = new Descricao();
        str = d.criaDescricaoConta(str,s);
        System.out.println(str);
    }
    */

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzo valor em euros:");
        int eu = sc.nextInt();
        System.out.println("Introduzo taxa de conversão:");
        double taxa = sc.nextDouble();
        Europaralibras el = new Europaralibras();
        double result = el.eurosParaLibras(eu,taxa);
        System.out.println("Valor em libras: " + result);
    }
    */

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzo dois inteiros:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        Media m = new Media();
        String s = m.media(a,b);
        System.out.println(s);
    }
    */

    /*
    public static void main(String[] args) {
        Fatorial f = new Fatorial();
        long n = f.factorial(Integer.parseInt(args[0]));
        System.out.println("Fatorial: " + n);
    }
    */

    public static void main(String[] args) {
        Tempogasto t = new Tempogasto();
        long tempo = t.tempoGasto();
        System.out.println("Tempo decorrido para a execução: " + tempo);
    }
}
