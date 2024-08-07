import java.util.Scanner;

public class IdadeUfam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int ano_fund = 1909;
		int ano_atual = scan.nextInt();
		
		int idade = ano_atual-ano_fund;
		
		System.out.println("A UFAM tem "+idade+" anos de fundacao");
		scan.close();
	}

}