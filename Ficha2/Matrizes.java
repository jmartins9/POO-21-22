package com.company;

import java.util.Scanner;

public class Matrizes {

    public static void lematriz (int [][] matriz,Scanner sc) {
        for(int i=0;i<matriz.length;i++) {
            for (int j=0;j<matriz[i].length;j++) {
                System.out.println("Insira elemento da posiçao " + i + " " + j);
                matriz[i][j]=sc.nextInt();
            }
        }
    }

    public static int[][] somamatrizes (int [][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[matriz1.length][matriz1[0].length];
        for(int i=0;i<matriz1.length;i++) {
            for (int j=0;j<matriz1[i].length;j++) {

                resultado[i][j]=matriz1[i][j]+matriz2[i][j];
            }
        }
        return resultado;
    }

    public static boolean matrizesiguais (int [][] matriz1, int[][] matriz2) {
        for(int i=0;i<matriz1.length;i++) {
            for (int j=0;j<matriz1[i].length;j++) {
                if (matriz1[i][j]!=matriz2[i][j]) return false;
            }
        }
        return true;
    }

    public static void matrizoposta (int[][] matriz) {
        for(int i=0;i<matriz.length;i++) {
            for (int j=0;j<matriz[i].length;j++) {
                matriz[i][j]=-matriz[i][j];
            }
        }
    }

    public static void mostrarmatriz (int[][] matriz) {
        for(int i=0;i<matriz.length;i++) {
            for (int j=0;j<matriz[i].length;j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
