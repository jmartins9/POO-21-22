package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Oparrays {

    int[] valores;
    Scanner scanner;

    public Oparrays(int n, Scanner sc) {
        valores = new int[n];
        scanner = sc;
    }

    public int preencheMinArray () {

        int min = Integer.MAX_VALUE;
        for(int i=0;i<valores.length;i++) {
            valores[i]= scanner.nextInt();
            if (valores[i]<min) {
                min = valores[i];
            }
        }
        return min;
    }

    public int[] preencheEntreArray(int i1,int i2) {
        int[] array = new int[Math.abs(i2-i1)+1];
        System.arraycopy(valores,Math.min(i1,i2),array,0,array.length);
        return array;
    }


    public int[] communarray(Oparrays x) {
        int ic = 0;
        int[] commun = new int[Math.max(valores.length,x.valores.length)];
        Arrays.sort(x.valores);

        for (int i=0;i<valores.length;i++) {
            if (Arrays.binarySearch(x.valores,valores[i])>=0) {
                commun[ic++] = valores[i];
            }
        }
        return commun;
    }

}
