package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("    EUROMILHOES\n");
        System.out.println("Insira primeiro os 5 numeros e 2 estrelas em seguidas");

        int[] numeros = new int[5];
        int[] num = new int[5];
        int estrela1 = (int) (Math.random()*12);
        int estrela2 = (int) (Math.random()*12);
        int i;

        Scanner sc = new Scanner(System.in);

        for (i=0;i<5;i++) {
            numeros[i]=sc.nextInt();
            num[i]=(int) (Math.random()*49);
            System.out.print(num[i]+" ");
        }
        System.out.print(estrela2+" ");
        System.out.print(estrela1+" ");
        int est1 = sc.nextInt();
        int est2 = sc.nextInt();

        Arrays.sort(numeros);

        if (estrela1 == est1 &&
            estrela2 == est2 &&
            Arrays.binarySearch(numeros,num[0])>=0 &&
            Arrays.binarySearch(numeros,num[1])>=0 &&
            Arrays.binarySearch(numeros,num[2])>=0 &&
            Arrays.binarySearch(numeros,num[3])>=0 &&
            Arrays.binarySearch(numeros,num[4])>=0
        )
            System.out.println("Ganhou");

    }
}
