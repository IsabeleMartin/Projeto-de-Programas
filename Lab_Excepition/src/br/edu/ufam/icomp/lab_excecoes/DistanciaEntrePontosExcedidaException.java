package br.edu.ufam.icomp.lab_excecoes;

public class DistanciaEntrePontosExcedidaException extends RoverCaminhoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DistanciaEntrePontosExcedidaException() {
		// TODO Auto-generated constructor stub
		this("Distância máxima entre duas coordenadas vizinhas excedida");
	}

	public DistanciaEntrePontosExcedidaException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
