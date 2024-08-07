
public class TreinadorJedi {
	String titulacao;
	String nome;
	
	TreinadorJedi(){
		titulacao = "";
		nome = "";
	}
	
	TreinadorJedi(String titulacao, String nome){
		this.titulacao = titulacao;
		this.nome = nome;
	}
	
	String getDescricao(){
		return titulacao +" "+nome;
	}
}
