package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaForaDosLimitesException extends RoverCoordenadaException{

	private static final long serialVersionUID = 1L;

	public CoordenadaForaDosLimitesException() {
		// TODO Auto-generated constructor stub
		this ("Coordenada com valores fora dos limites");
		
	}

	public CoordenadaForaDosLimitesException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
	
	

}
