import java.util.Scanner;

public class Soma {

    public static void main(String[] args) {
        soma();
    }

    public static void soma () {
        Scanner sc = new Scanner(System.in);

        int soma = 0;
        int i;
        for(i=0;i<10;i++) {
            System.out.println("Insira o próximo inteiro:");
            soma += sc.nextInt();
        }
        System.out.println("A soma é: " + soma);
    }
}
