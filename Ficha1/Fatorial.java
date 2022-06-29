
public class Fatorial {
    public long factorial(int num) {
        long fac = num;
        for (int i=1;i<num;i++) {
            fac *= i;
        }
        return fac;
    }
}
