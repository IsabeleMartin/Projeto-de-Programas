


import java.util.Scanner;

public class SomaColecoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int vector[] = new int [100];
		
		int coletor = 0,i=0, j = 0;
		
		int cont = 0;
		
		int somador = 0;
		
		coletor = scan.nextInt();
		
		while(cont != 2) {
			
			
			vector[j] = coletor;
			
			coletor = scan.nextInt();
			
			j++;	
			
			if(coletor == -1) {
				cont++;
			}else {
				if(cont>0) {
					cont--;
				}
			}
		}
		
		
		while(i<=j) {
			
			if(vector[i] == -1) {
				System.out.println(somador);
				i++;
				somador = 0;
			}
			
			somador = somador + vector[i];
			i++;
		}
		

		
		scan.close();
	}

}
