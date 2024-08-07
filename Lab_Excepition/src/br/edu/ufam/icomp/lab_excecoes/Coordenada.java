package br.edu.ufam.icomp.lab_excecoes;


public class Coordenada  {
	private int posX;
	private int posY;
	private int digito;

	public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException{
		// TODO Auto-generated constructor stub
		if(posX < 0 || posY < 0) throw new CoordenadaNegativaException();
		if(posX < 0 || posX > 30000 || posY < 0 || posY > 30000) throw new CoordenadaForaDosLimitesException();
		if((((posX+posY)%10) != digito) || digito < 0 || digito >9) throw new DigitoInvalidoException();
		this.setDigito(digito);
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}

	public double distancia(Coordenada coordenada) {
		return Math.sqrt(Math.pow(coordenada.posX - this.posX, 2) + Math.pow(coordenada.posY - this.posY, 2));
	}
	
	public String toString() {
		return posX +", "+posY;
	}

	public int getDigito() {
		return digito;
	}

	public void setDigito(int digito) {
		this.digito = digito;
	}
}
