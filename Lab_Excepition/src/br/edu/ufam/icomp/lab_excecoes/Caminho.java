package br.edu.ufam.icomp.lab_excecoes;


public class Caminho {
	private Coordenada[] caminho;
	private int tamanho;

	public Caminho(int maxTam) {
		// TODO Auto-generated constructor stub
		caminho = new Coordenada[maxTam];
		tamanho = 0;
	}
	
	public int tamanho() {
		return this.tamanho;
	}
	
	public void addCoordenada(Coordenada coordenadas) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException  {
		if(cheio(caminho) == true) throw new TamanhoMaximoExcedidoException(); // VERIFICA SE O VETOR ESTÁ CHEIO, SE SIM, GERA EXCEÇÃO 
		
		Coordenada aux = tamanho==0?coordenadas:caminho[tamanho()-1];			   // SE O VETOR ESTIV
		
		double dis = coordenadas.distancia(aux);
		if(dis > 15) throw new DistanciaEntrePontosExcedidaException();
		if(cheio(caminho)==false || dis < 15) {
			if(tamanho == 0) {
				caminho[tamanho()] = coordenadas;
				
				tamanho++;
			}else {
				
				int k = tamanho();
				
				caminho[k] = coordenadas;
				tamanho++;
			}			
		}
		
		
		
		
	}
	
	private boolean cheio(Coordenada[] caminho2) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < caminho2.length; i++) {
		
			if(caminho[i] == null) {
				return false;
			}
		}
		return true;
	}

	public void reset() {
		for (int i = 0; i < caminho.length; i++) {
			Coordenada coordenada = null;
			caminho[i] = coordenada;
		}
		this.tamanho = 0;
	}

	public String toString() {
		String texto = "";
		
		texto = "Dados do caminho:\n - Quantidade de pontos: "+ tamanho()+"\n - Pontos:\n";
		for(int i = 0; i < tamanho(); i++) {
			Coordenada coor = caminho[i];
			//System.out.println(coor.toString());
			texto += "  -> " + coor.toString()+"\n";
		}
		
		return texto;
	}
}
