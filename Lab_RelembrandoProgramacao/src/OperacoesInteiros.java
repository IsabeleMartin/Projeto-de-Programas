import java.util.Scanner;

public class OperacoesInteiros {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inteiro[] = new int[100];
		int flag = 0;
		int i = 0;
		int cont = 0, pares = 0, impares = 0, soma = 0, maior = 0, menor = 0, elem = 0;
		double media = 0;
		//System.out.println("Insira os números (insira -1 duas vezes para terminar):");
		while(flag != 2) {
			inteiro[i] = scan.nextInt();
			if(inteiro[i] == -1) {
				flag++;
				cont++;
			}else {
				flag = 0;
			}
			i++;
		}
		
		/*for(int j = 0; j <=i ; j++) {
			System.out.print(inteiro[j] + " ");
		}*/
		
		i = 0;
		while(cont > 1 ) {
			pares = 0;
			impares = 0;
			maior = inteiro[i];
			menor = inteiro[i];
			soma = 0;
			elem = 0;
			while(inteiro[i] != -1) {
				elem++;
				
				if(inteiro[i]%2 == 0) {
					pares ++;
				}else {
					impares++;
				}if(inteiro[i] > maior) {
					maior = inteiro[i];
				}if(inteiro[i] < menor) {
					menor = inteiro[i];
				}
				soma += inteiro[i];
				
				i++;
			}
			media = (double) soma/elem;
			System.out.println(elem+ "\n" + pares + "\n" + impares + "\n" + soma );
			System.out.printf("%.2f\n%d\n%d", media, maior, menor);
			cont--;
			i++;
		}
		
		scan.close();
	}
}
