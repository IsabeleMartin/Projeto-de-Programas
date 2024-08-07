package Lab_Introducao;
import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vector[] = new int[100];
		int i = 0;
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.print("Digite os números: ");
		int idade = scan.nextInt();
		
		while(idade > -1) {
			vector[i] = idade;
			i++;
			idade = scan.nextInt();
		//	System.out.println(vector[i]);
			
		}
		scan.close();
		
		for(int j = 0; j<i; j++) {
			//System.out.print(vector[j]);
			if (vector[j]%2 == 0) {
				System.out.println("PAR");
			}
			else {
				System.out.println("IMPAR");
			}
			
		}
		
		
		
		
	}

}
