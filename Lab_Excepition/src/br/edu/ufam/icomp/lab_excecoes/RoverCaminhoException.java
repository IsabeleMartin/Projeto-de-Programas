package br.edu.ufam.icomp.lab_excecoes;

public class RoverCaminhoException extends RoverException {
	
	private static final long serialVersionUID = 1L;

	public RoverCaminhoException() {
		this ("Exceção geral de caminho do rover");
	}

	public RoverCaminhoException(String s) {
		super(s);
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
