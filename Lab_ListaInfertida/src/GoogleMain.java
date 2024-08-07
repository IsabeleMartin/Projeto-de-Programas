import java.util.LinkedList;

public class GoogleMain {

	public static void main(String[] args) {
		ListaInvertida list = new ListaInvertida();
		list.insere("morango", "documento1.txt");
		list.insere("bergamota", "documento2.txt");
		list.insere("laranja", "documento3.txt");
		list.insere("tomate", "documento4.txt");
		list.insere("morango", "documento5.txt");
		list.insere("morango", "documento6.txt");
		
		LinkedList<String> busc = list.busca("morango");
		System.out.print(busc.toString());
		System.out.println();
		
		System.out.println(list.toString());

	}

}
