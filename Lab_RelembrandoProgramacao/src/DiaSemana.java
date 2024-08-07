import java.util.Scanner;

public class DiaSemana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int dias[] = new int[100];
		int semana[] = new int[7];
		int cont = 0, i = 0, coletor = 0, j =0;
		int maior = 0;
		
		coletor = scan.nextInt();
		
		while( coletor != -1) {
		 
			dias[i] = coletor;
			coletor = scan.nextInt();
			i++;
			
		}
		
		while(cont < i/7) {
			semana[0] += dias[j];
			semana[1] += dias[j+1];
			semana[2] += dias[j+2];
			semana[3] += dias[j+3];
			semana[4] += dias[j+4];
			semana[5] += dias[j+5];
			semana[6] += dias[j+6];
			j += 7;
			cont++;
		}
		
		for(int k = 0; k < 7; k++) {
			if(semana[k]>= maior) {
				maior = semana[k];
			}
		}
		
		for(int k = 0; k < 7; k++) {
			if(semana[k] == maior) {
				System.out.println(k+1);
			}
		}
		
		scan.close();
	}

}
