 
public class Sala {
	int bloco;
	int sala;
	int capacidade;
	boolean acessivel;
	
	Sala(){
		bloco = 0;
		sala = 0;
		capacidade = 0;
		acessivel = false;
	}
	
	Sala(int bloco, int sala, int capacidade, boolean acessivel){
		this.acessivel = acessivel;
		this.bloco = bloco;
		this.capacidade = capacidade;
		this.sala = sala;
	}
	
	String getDescricao() {
		if (acessivel) {
			return "Bloco "+bloco+", Sala "+sala+" ("+capacidade+" lugares, acessível)";
		}else {
			return "Bloco "+bloco+", Sala "+sala+" ("+capacidade+" lugares, não acessível)";
		}
		
	}
}
