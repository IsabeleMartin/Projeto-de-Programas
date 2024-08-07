
public class IniciadoJedi {
	String nome;
	String especie;
	int anoNascimento;
	
	IniciadoJedi(){
		nome = "";
		especie = "";
		anoNascimento = 0;
		
	}
	IniciadoJedi(String nome, String especie, int anoNascimento){
		this.nome = nome;
		this.especie = especie;
		this.anoNascimento = anoNascimento;
	}
	String getAnoNascimento() {
		if(anoNascimento < 0) {
			int ano = Math.abs(anoNascimento);
			return ano+" ABY";
		
		}else {
			return anoNascimento + " DBY";
		}
	}
	
	String getDescricao() {
		return (nome +" (especie="+especie+", nascimento="+getAnoNascimento()+")");
	}

}
