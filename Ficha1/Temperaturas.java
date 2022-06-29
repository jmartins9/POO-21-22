import java.util.Scanner;

public class Temperaturas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o número de temperaturas (duas ou mais):");
        int n = sc.nextInt();
        int i = 1, t, tant = -1, m = 0, v = -1,vmax=-1,dia=1;
        for (i = 1; i <= n; i++) {
            System.out.println("Insira temperatura:");
            t = sc.nextInt();
            if (tant != -1) {
                v = tant-t;
                v = Math.abs(v);
                if (v > vmax) {
                    vmax = v;
                    dia = i;
                }
                m = (m + t) / 2;
            }
            else m=t;
            tant = t;
        }

        System.out.println("A média das " + n + " temperaturas foi de " + m + " graus.");
        System.out.println("A maior variação registou-se entre os dias " + (dia-1) + " e " + dia + ", tendo a temperatura subido/descido " + vmax + " graus.");
    }
}
