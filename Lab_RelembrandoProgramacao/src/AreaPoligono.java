import java.util.Scanner;

public class AreaPoligono {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		double coletor = 0;
		double x[] = new double[100];
		double y[] = new double[100];
		int i = 0;
		int cont = 0; 
		double somatorio = 0;
		int j2 = 0;
		
		coletor = scan.nextDouble();
		
		while(coletor != -1) {
			x[i] = coletor;
			i++;	
			
			coletor = scan.nextDouble();
		}
		coletor = scan.nextDouble();
		
		while(i > 0) {
			y[j2] = coletor;
			i--;
			j2++;
			
			coletor = scan.nextDouble();
		}
		j2--;
		//System.out.println(x[0] + " == "+x[j2]+ ", "+ y[0] + " == "+ y[j2] );
		if(x[0] == x[j2] && y[0] == y[j2]) {
			while(cont <= j2-1) {
				somatorio = somatorio + ((x[cont+1] + x[cont])*(y[cont+1] - y[cont]));
				cont++;
			}
		}
		somatorio=Math.abs(somatorio);
		//System.out.println("elementos não são iguais");
		
		/*for(int j = 0; j <= ; j++) {
			
		}*/
		
		System.out.printf("%.4f", somatorio/2);
		
		scan.close();
	}
		
}
//4 4 7 7 9 7 4 -1 0 7,5 7,5 3 0 0 0 -1

