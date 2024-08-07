package br.edu.icomp.ufam.lab_heranca;

public abstract class FormaGeometrica {
    public int posX;
    public int posY;

    public FormaGeometrica(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public String getPosString() {
        return "posição (" + this.posX + ", " + this.posY + ")";
    }

    public abstract double getArea();

    public abstract double getPerimetro();
}

	
