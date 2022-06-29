package com.company;

import java.util.Arrays;

public class Notas {

    private int[][] notasTurma;

    public Notas () {
        this.notasTurma = new int[5][5];
    }

    public void insereNota (int nota, int linha, int coluna) {
        this.notasTurma[linha][coluna]= nota;
    }

    public int getNumeroAlunos () {
        return this.notasTurma.length;
   }

   public int getNumeroUcs (int aluno) {
        return this.notasTurma[aluno].length;
   }

   public int somaNotasUc (int uc) {
        int soma = 0;
        for (int i=0;i<this.getNumeroAlunos();i++) {
            soma += this.notasTurma[i][uc];
        }
        return soma;
   }

   public String toString () {
       String str = "";
       for (int i=0;i<this.getNumeroAlunos();i++) {
           str = str + "Aluno " + i + ": " + Arrays.toString(this.notasTurma[i]) + "\n";
       }
       return str;
   }

   public int mediaAluno (int aluno) {
        int media = 0;
        int i;
        for (i=0;i<this.getNumeroUcs(aluno);i++) {
            media += this.notasTurma[aluno][i];
        }
        return media/i;
   }

   public int mediaUc (int uc) {
       int media = somaNotasUc(uc);
       return media/this.getNumeroAlunos();
   }

   private int notaMaisAltaUc (int uc) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<this.getNumeroAlunos();i++) {
            if (this.notasTurma[i][uc] > max) {
                max = this.notasTurma[i][uc];
            }
        }
        return max;
   }

   public String notasMaisAltasTodasUcs () {
        String str = "";
        for (int i=0;i<this.getNumeroAlunos();i++) {
            str = str + "Uc " + i + ": " + this.notaMaisAltaUc(i) + "\n";
        }
        return str;
   }

    private int notaMaisBaixaUc (int uc) {
        int max = Integer.MAX_VALUE;
        for (int i=0;i<this.getNumeroAlunos();i++) {
            if (this.notasTurma[i][uc] < max) {
                max = this.notasTurma[i][uc];
            }
        }
        return max;
    }

    public String notasMaisBaixasTodasUcs () {
        String str = "";
        for (int i=0;i<this.getNumeroAlunos();i++) {
            str = str + "Uc " + i + ": " + this.notaMaisBaixaUc(i) + "\n";
        }
        return str;
    }


    public int[] notasAcimaDe (int valor) {
        int[] notas = new int[this.getNumeroAlunos()*this.getNumeroUcs(0)];
        int in = 0;
        for (int i=0;i<this.getNumeroAlunos();i++) {
            for (int j=0;j<this.getNumeroUcs(i);j++) {
                if (this.notasTurma[i][j]>valor) {
                    notas[in++] = this.notasTurma[i][j];
                }
            }
        }
        return notas;
    }

    public int mediaUcMaisElevada () {
        int id=-1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<this.getNumeroUcs(0);i++) {
            if (mediaUc(i)>max) {
                max = mediaUc(i);
                id = i;
            }
        }
        return id;
    }




}
