import java.util.Scanner;

public class CaixaEletronico {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int dinheiro = scan.nextInt();
		
		if((dinheiro%2 != 0) || (dinheiro < 0)) {
			System.out.println("Valor Invalido");
		}else {
			int Cin = dinheiro/50;
			int Dez = (dinheiro - Cin*50)/10;
			int dois = (dinheiro - Cin*50 - Dez*10)/2;
			
			System.out.println(Cin + " notas de R$50, "+Dez+" notas de R$10 e "+ dois + " notas de R$2");
		}
		
		
		scan.close();
	}
	

}
