import java.util.Scanner;

public class AreaTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		
		if((a+b)<=c || (a+c)<=b || (c+b)<=a) {
			System.out.println("Triangulo invalido");
		}else {
			int S = (a+b+c)/2;
			
			double A = Math.sqrt(S*(S-a)*(S-b)*(S-c));
			
			System.out.printf("%.2f\n", A);
		}
		scan.close();
		
	}

}
