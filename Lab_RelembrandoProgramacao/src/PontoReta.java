
import java.util.Scanner;

public class PontoReta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float x = 0;
		float y = 0;
		
		Scanner scan = new Scanner(System.in);
		
		x =  scan.nextFloat();
		y =  scan.nextFloat();
		
		float rest = 2*x + y;
		
		if(rest == 3) {
			System.out.println("Ponto ("+x+", "+y+") pertence a reta 2x + y = 3.");
		}else {
			System.out.println("Ponto ("+x+", "+y+") nao pertence a reta 2x + y = 3.");
		}
		
		scan.close();

	}

}
