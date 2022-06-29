package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Arraylocaldate {

    private LocalDate[] array;
    private int pos;

    public Arraylocaldate (int dimensao) {
        array = new LocalDate[dimensao];
        pos = 0;
    }

    public void insereData (LocalDate data) {
        this.array[this.pos++]=data;
    }

    public LocalDate dataMaisProxima (LocalDate data) {
        int time = Integer.MAX_VALUE;
        int id = 0;
        for (int i=0;i<this.pos;i++) {
            Period p;
            if (this.array[i].isBefore(data)) {
                p = Period.between(this.array[i],data);
            }
            else {
                p = Period.between(data,this.array[i]);
            }
            if ((p.getDays() + p.getYears() + p.getMonths()) < time) {
                time = p.getDays() + p.getYears() + p.getMonths();
                id = i;
            }

        }
        return this.array[id];
    }


    public String toString() {
        String str = "";
        for (int i=0;i<this.pos;i++) {
            str = str + this.array[i].toString() + ", ";
        }
        return str;
    }


}
