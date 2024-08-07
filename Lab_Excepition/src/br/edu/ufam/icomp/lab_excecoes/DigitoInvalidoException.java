package br.edu.ufam.icomp.lab_excecoes;

public class DigitoInvalidoException extends RoverCoordenadaException {

	private static final long serialVersionUID = 1L;

	public DigitoInvalidoException() {
		// TODO Auto-generated constructor stub
		this("Digito da coordenada inválido");
	}

	public DigitoInvalidoException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
