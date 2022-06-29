import java.util.Scanner;

public class Primos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=2;i<=n;i++) {
            if(isPrimo(i)) System.out.print(i+" ");
        }
        System.out.println();
    }

    public static boolean isPrimo (int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0)
                return false;
        }
        return true;
    }

}
