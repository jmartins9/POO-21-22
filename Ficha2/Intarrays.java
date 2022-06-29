package com.company;

import java.util.Arrays;

public class Intarrays {

    public static void ordenaArrayInteiros (int[] array) {
        Arrays.sort(array);
    }

    public static int procuraBinariaArrayInteiros (int[] array,int elemento) {
        return Arrays.binarySearch(array,elemento);
    }

}
