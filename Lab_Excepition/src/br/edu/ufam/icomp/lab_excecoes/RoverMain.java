package br.edu.ufam.icomp.lab_excecoes;

public class RoverMain {

	public static void main(String[] args) {		
		try {
			Caminho c = new Caminho(6);
			Coordenada r1 = new Coordenada(23, 55, 8);
			c.addCoordenada(r1);
			Coordenada r2 = new Coordenada(27, 65, 2);
			c.addCoordenada(r2);
			
			System.out.println(c.toString());
			
		}catch(CoordenadaNegativaException e) {
			e.toString();
			
		}catch(CoordenadaForaDosLimitesException e) {
			e.toString();
			
		}catch(DigitoInvalidoException e) {
			e.toString();
			
		}catch(TamanhoMaximoExcedidoException e) {
			e.toString();
			
		}catch(DistanciaEntrePontosExcedidaException e) {
			e.toString();
			
		}
		
	}

}
