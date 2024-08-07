import java.util.Scanner;

public class AproximacaoSeno {
	
	private static double angulo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		angulo = scan.nextDouble();
		int cont = scan.nextInt();
		double termo = 0;
		double soma = 0;
		int i = 0, j = 3;
		
		
		angulo = Math.toRadians(angulo);
		soma = angulo;
		
		while(i < cont) {
			if(i == 0) {
				termo = 0;
				i++;
			}else {
				
				termo =  Math.pow(-1, i)*(Math.pow(angulo,j)/fator(j));
				i++;
				j = j + 2;
			}
			soma = soma + termo;
			
			//System.out.printf("%.10f  ",termo);
			System.out.printf("%.10f\n", soma);
		}
		//termo =  Math.pow(-1, i)*(Math.pow(angulo,j)/fator(j));
		//System.out.printf("%.10f  ",termo);
		scan.close();
	}

	private static double fator(int i) { // FUNÇÃO FUNCIONANDO
		// TODO Auto-generated method stub
		double fatorial = 1;
		for(int j = 1; j <= i; j++) {
			
			fatorial = fatorial*j;
			
		}
		return fatorial;
		
	}

}
