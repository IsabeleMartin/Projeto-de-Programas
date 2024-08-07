
import java.util.Scanner;

public class AnimaisCedulas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float valor = 0;
		
		Scanner scan = new Scanner(System.in);
		
		valor = scan.nextFloat();
		if(valor == 2) {
			System.out.println("Tartaruga");
		}else if(valor == 5) {
			System.out.println("Garça");
		}else if(valor == 10) {
			System.out.println("Arara");
		}else if(valor == 20) {
			System.out.println("Mico-leão-dourado");
		}else if(valor == 50) {
			System.out.println("Onça-pintada");
		}else if(valor == 100) {
			System.out.println("Garoupa");
		}else {
			System.out.println("erro");
		}
		
		scan.close();
	}

}
