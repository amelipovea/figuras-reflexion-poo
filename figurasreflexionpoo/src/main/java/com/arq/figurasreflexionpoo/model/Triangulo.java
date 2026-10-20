package com.arq.figurasreflexionpoo.model;

public class Triangulo implements FiguraGeometrica{
    public double ladoA;
    public double ladoB;
    public double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }

    @Override
    public double calcularArea() {
        if (this.ladoA + this.ladoB <= this.ladoC || this.ladoA  + this.ladoC <= this.ladoB || this.ladoB + this.ladoC <= this.ladoA ) {
            throw new IllegalArgumentException("Error: Las medidas ingresadas no pueden formar un triángulo válido.");
        }

        double semiperimetro = calcularPerimetro()/2;
        return Math.sqrt(semiperimetro*(semiperimetro-this.ladoA) * (semiperimetro-this.ladoB) * (semiperimetro-this.ladoC));
    }

    @Override
    public double calcularPerimetro() {
        return this.ladoA+this.ladoB+this.ladoC;
    }
}
