import java.util.Scanner;

public class SomaColecao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int vector[] = new int [100];
		
		int coletor = 0, j = 0;
		
		int somador = 0;
		
		coletor = scan.nextInt();
		
		while(coletor != -1) {
			
			
			vector[j] = coletor;
			
			coletor = scan.nextInt();
			
			j++;		
			
		}
		
		for(int i = 0; i <= j; i++) {
			
			somador = somador + vector[i];
			
		}
		
		System.out.println(somador);
		
		scan.close();
	}

}