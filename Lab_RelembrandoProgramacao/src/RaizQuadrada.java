import java.util.Scanner;
public class RaizQuadrada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		double raiz = Math.sqrt(num);
		System.out.printf("%.4f\n",raiz);
		scan.close();
	}

}