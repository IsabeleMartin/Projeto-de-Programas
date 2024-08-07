import java.util.Hashtable;
import java.util.LinkedList;

public class ListaInvertida {
	private Hashtable<String, LinkedList<String>> tabela;
	
	public ListaInvertida(){
		tabela = new Hashtable<String, LinkedList<String>>();
		
	}
	
	public boolean insere(String palavra, String documento) {
		LinkedList<String> hash = tabela.get(palavra);
		if(hash == null) {
			LinkedList<String> lista = tabela.getOrDefault(palavra, new LinkedList<>());
	        lista.add(documento);
	        tabela.put(palavra, lista);
			return true;
		}else {
			if(hash.contains(documento)) {
				return false;
			}else {
				LinkedList<String> lista = tabela.getOrDefault(palavra, new LinkedList<>());
		        lista.add(documento);
		        tabela.put(palavra, lista);
				return true;
			}
		}
		
	}
	
	public LinkedList<String> busca(String palavra){
		return tabela.get(palavra);
	}
	
	public String toString() {
		return tabela.toString();
	}
}
