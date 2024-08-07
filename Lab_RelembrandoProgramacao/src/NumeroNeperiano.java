import java.util.Scanner;

public class NumeroNeperiano {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int valor = scan.nextInt();
		
		double fatorial = 1, somador = 0;
		
		int i = 0;
		
		while (i < valor) {
			if(valor == 1) {
				fatorial = 1;
			}else {
				fatorial = 1;
				for(int j = 1; j <= i; j++) {
					
					fatorial = fatorial*j;
					
				}
			}
			//System.out.printf("%.6f\n",fatorial);
			somador = somador + (1.0/fatorial);
			i++;
		}
		System.out.printf("%.6f",somador);
		
		scan.close();
	}

}
