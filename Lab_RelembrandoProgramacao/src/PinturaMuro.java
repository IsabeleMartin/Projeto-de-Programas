import java.util.Scanner;
public class PinturaMuro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int material = 100;
		int x = 12, y = 3;
		Scanner scan = new Scanner(System.in);
		double valor = scan.nextDouble();
		
		double total = material + ((x*y)*valor);
		System.out.printf("%.1f\n",total);
		scan.close();
	}

}