import java.util.Scanner;

public class Areaperimetro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base,altura,area,perimetro,cateto;
        while((base = sc.nextInt())!=0) {
            altura = sc.nextInt();
            area = (base*altura)/2;
            System.out.printf("Área: %.5f ",area);
            cateto = base*base + altura*altura;
            cateto = Math.sqrt(cateto);
            perimetro = base+altura;
            System.out.printf("Perimetro: %.5f \n",perimetro);
        }
    }
}
