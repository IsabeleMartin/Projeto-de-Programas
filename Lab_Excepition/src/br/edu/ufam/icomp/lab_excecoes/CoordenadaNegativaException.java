package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaNegativaException extends RoverCoordenadaException{

	private static final long serialVersionUID = 1L;

	public CoordenadaNegativaException() {
		// TODO Auto-generated constructor stub
		this ("Coordenada com valor negativo");
	}
	
	public CoordenadaNegativaException(String s) {
		super(s);
	}

	public String getMessage() {
		return super.getMessage();
	}
}
