import java.util.Scanner;

public class RaizDois {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
				
		ExpFracao(num);
				
		scan.close();
		
	}
	public static void ExpFracao(int num) {
		double termo = 1;
		double fracao = 0;
		while(num > 0) {
			termo = 1/(2+termo);
			fracao = 1 + termo;
			System.out.printf("%.14f\n", fracao);
			num--;
		}
	}

}
