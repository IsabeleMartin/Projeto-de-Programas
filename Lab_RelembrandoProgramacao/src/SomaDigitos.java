import java.util.Scanner;

public class SomaDigitos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int soma = 0;
		int dez = 10;
		
		while(num>1) {
			soma = soma + num%dez;
			//dez = dez*10;
			num = num/10;
			
		}
		scan.close();
		System.out.println(soma);
	}

}
