package br.edu.icomp.ufam.lab_heranca;

public class Retangulo extends FormaGeometrica{
	public double largura;
	public double altura;
	
	public Retangulo(int posX, int posY, double largura, double altura) {
		super(posX,posY);
		this.altura = altura;
		this.largura = largura;
		
	}
	
	public double getArea() {
		return largura*altura;
	}
	
	public double getPerimetro() {
		return 2*(largura + altura);
	}
	
	public String toString() {
		return "Retângulo na posição ("+posX+", "+posY+") com largura de "+largura+"cm e altura de "+altura+"cm (área="+getArea()+"cm2, perímetro="+getPerimetro()+"cm)";
	}
	

}
