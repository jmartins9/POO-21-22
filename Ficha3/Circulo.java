package com.company;

public class Circulo {
    private Ponto centro;
    private double raio;


    public Circulo(Circulo c) {
        this.centro = c.getCentro();
        this.raio = c.getRaio();
    }

    public Circulo() {
        this.centro = new Ponto();
        this.raio = 0;
    }
    
    public Circulo(Ponto centro, double raio) {
        this.centro = new Ponto(centro);
        this.raio = raio;
    }


    public Circulo(int x, int y, double raio) {
        this.centro = new Ponto(x,y);
        this.raio = raio;
    }

    public int getX() { return this.centro.getX(); }

    public void setX(int x) { this.centro.setX(x); }

    public Ponto getCentro() { return centro.clone(); }

    public void setCentro(Ponto centro) { this.centro = centro; }

    public int getY() {
        return this.centro.getY();
    }

    public void setY(int y) { this.centro.setY(y); }

    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCentro (int x, int y) { this.centro.movePonto(x,y); }

    public void alteraCentro (Ponto p) { this.centro = p.clone(); }
 
    public double calculaArea() {
        return Math.PI*raio*raio;
    }
    
    public double calcularPerimetro() {
        return 2*Math.PI*raio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if ((o == null) || (this.getClass()!= o.getClass())) return false;
        
        Circulo c = (Circulo) o;
        return this.centro.equals(c.centro) &&
               this.getRaio()==c.getRaio();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("x: ");
        sb.append(this.getX());
        sb.append(" Y: ");
        sb.append(this.getY());
        sb.append(" Raio: ");
        sb.append(this.getRaio());
        return sb.toString();
    }
    
    public Circulo clone() {
        return (new Circulo(this));
    }

}
