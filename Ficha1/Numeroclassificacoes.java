import java.util.Scanner;

public class Numeroclassificacoes {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o número de classificações:");
        int n = sc.nextInt();
        int i,int1,int2,int3,int4;
        float c;
        int1=int2=int3=int4=0;
        for (i=0;i<n;i++) {
            System.out.println("Insira classificação entre 0 a 20:");
            c = sc.nextFloat();
            if (c<5) int1++;
            else if (c<10) int2++;
            else if (c<15) int3++;
            else if (c<=20) int4++;
        }
        System.out.println("Número de classificações entre:");
        System.out.println("[0,5[: " + int1);
        System.out.println("[5,10[: " + int2);
        System.out.println("[10,15[: " + int3);
        System.out.println("[15,20]: " + int4);
    }
}
