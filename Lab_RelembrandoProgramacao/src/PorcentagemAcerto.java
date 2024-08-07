import java.util.Scanner;

public class PorcentagemAcerto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int coletor = 0;
		int anwser[] = new int[100];
		int gabarito[] = new int[100];
		int i = 0;
		double cont = 0;
		int j2 = 0;
		
		coletor = scan.nextInt();
		
		while(coletor != -1) {
			anwser[i] = coletor;
			//System.out.print(anwser[i]);
			i++;
			coletor = scan.nextInt();
		}
		coletor = scan.nextInt();
		
		while(i > 0) {
			gabarito[j2] = coletor;
			i--;
			j2++;
			coletor = scan.nextInt();
		}
		
		
		for(int j = 0; j < j2; j++) {
			if (anwser[j] == gabarito[j]) {
				cont++;
				//System.out.printf("%.2f ", cont);
			}
			//System.out.print("i: ");
			//System.out.print(anwser[j]);
			//System.out.print(" j: ");
			//System.out.println(gabarito[j]);
			
		}
		
		double resulte = (cont/j2)*100;
		
		System.out.printf("%.2f\n",resulte);
		
		scan.close();

	}

}
