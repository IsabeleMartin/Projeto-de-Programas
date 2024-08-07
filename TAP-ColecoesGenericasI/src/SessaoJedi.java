import java.util.ArrayList;
import java.util.Iterator;

public class SessaoJedi {
	String nome;
	TreinadorJedi treinador;
	ArrayList<IniciadoJedi> iniciados;
	
	
	

	SessaoJedi(String nome, TreinadorJedi treinador){
		this.nome = nome;
		this.treinador = treinador;
	}
	
	void addIniciado(IniciadoJedi iniciado) {
		if(iniciados == null) {
			iniciados = new ArrayList<IniciadoJedi>();
			iniciados.add(iniciado);
		}else {
			if(iniciados.indexOf(iniciado) == -1) {
				iniciados.add(iniciado);
			}
		}
	}
	
	IniciadoJedi getIniciado(String nome) {
		Iterator<IniciadoJedi> it = iniciados.iterator();
		while (it.hasNext()) {
			IniciadoJedi jedi = it.next();
			if(jedi.nome == nome) {
				return jedi;
			}
		}
		return null;
	}
	
	double getMediaAnoNascimento() {
		double soma = 0;
		Iterator<IniciadoJedi> it = iniciados.iterator();
		while(it.hasNext()) {
			IniciadoJedi jedi = it.next();
			soma += jedi.anoNascimento;
		}
		return soma/iniciados.size();
	}
	
	String getDescricao() {
		int i = 1;
		String descricao = "--> SESSÃO "+ nome +" (Treinador: "+ treinador.getDescricao()+")\n";
		Iterator<IniciadoJedi> it = iniciados.iterator();
		while(it.hasNext()) {
			IniciadoJedi jedi = it.next();
			descricao = descricao+ "  - Iniciado "+ i +": "+jedi.getDescricao()+"\n";
			i++;
		}
		return descricao;
		
	}
	
	
}
