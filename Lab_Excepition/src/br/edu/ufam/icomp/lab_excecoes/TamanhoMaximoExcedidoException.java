package br.edu.ufam.icomp.lab_excecoes;

public class TamanhoMaximoExcedidoException extends RoverCaminhoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TamanhoMaximoExcedidoException() {
		// TODO Auto-generated constructor stub
		this("Quantidade máxima de coordenadas excedida");
	}

	public TamanhoMaximoExcedidoException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
