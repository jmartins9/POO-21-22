package com.company;

public class Stringsclass {

    private static boolean pertence (String[] array,String str,int tamanho) {
        for (int i=0;i<tamanho;i++) {
            if (array[i].compareTo(str)==0) return true;
        }
        return false;
    }

    public static String[] arraysemrepeticoes (String[] array) {
        String[] result = new String[array.length];
        int ir = 0;
        for (int i=0;i<array.length;i++) {
            if (!pertence(result,array[i],ir)) result[ir++]=array[i];
        }

        return result;
    }

    public static String maiorstring (String[] array) {
        String str = "";
        for (int i=0;i<array.length;i++) {
            if (str.compareTo(array[i])<0) str = array[i];
        }
        return str;
    }


    public static String[] stringsrepetidas (String[] array) {
        String[] result = new String[array.length];
        int ir = 0;
        for (int i=0;i<array.length;i++) {
            if (numerodastring(array,array[i])>1) result[ir++]=array[i];
        }
        return result;
    }

    public static int numerodastring (String[] array, String str) {
        int n = 0;
        for(int i=0;i<array.length;i++) {
            if (array[i].compareTo(str)==0) n++;
        }
        return n;
    }


}
