import java.util.Scanner;

public class AproximacaoPi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		double grau = scan.nextDouble();
		
		double somador = 3, termo = 0;
		
		int j = 2, k = 3, l = 4, i = 0;
		
		if(grau == 1) {
			System.out.printf("%.6f\n",somador);
			i=3;
		}
		while (i < grau) {
			System.out.printf("%.6f\n",somador);
		    termo = Math.pow(-1, i)*(4.0/(j*k*l));
				
			somador = somador + termo;
			
			j = j + 2;
			k = k + 2;
			l = l + 2;
			i++;			
		
			
		}
		
		
		
		scan.close();
	}	

}
