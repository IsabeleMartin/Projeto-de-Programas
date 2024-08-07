import java.util.Scanner;

public class Desconto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		double promocao = 0;
		double preco = scan.nextDouble();
		double desconto = 0.95;
		
		if( preco>= 200 ) {
			promocao = preco*desconto;
		}else {
			promocao = preco;
		}
		
		
		
		
		System.out.printf("%.2f\n",promocao);
		scan.close();
		
	}

}
