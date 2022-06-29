package com.company;

public class Triangulo {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double calculaAreaTriangulo() {
        double r1 = y1*(x3-x2);
        double r2 = y2*(x1-x3);
        double r3 = y3*(x2-x1);
        return Math.abs(0.5*(r1+r2+r3));
    }


    public double calculaPerimetroTriangulo() {
        double r1 = x1-x2;
        double r2 = y1-y2;
        double d12 = Math.sqrt(r1*r1 + r2*r2);
        double r3 = x2-x3;
        double r4 = y2-y3;
        double d23 = Math.sqrt(r3*r3 + r4*r4);
        double r5 = x1-x3;
        double r6 = y1-y3;
        double d13 = Math.sqrt(r5*r5+r6*r6);
        return d12+d13+d23;
    }

    public double alturaTriangulo() {
        double h=0;
        if (y1>y2 && y1>y3) {
            if (y2>y3) h = y1-y3;
            else h = y1-y2;
        }
        else if (y2>y1 && y2>y3) {
            if (y1>y3) h = y2-y3;
            else h = y2-y1;
        }
        else if (y3>y1 && y3>y2) {
            if (y1>y2) h = y3-y2;
            else h = y3-y1;

        }
        return Math.abs(h);
    }

}
