import java.util.Scanner;

public class AreaVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		double raio = scan.nextDouble();
		
		
		double A = Math.PI*Math.pow(raio,2);
		double V = (4.0/3.0)*(Math.PI)*(Math.pow(raio, 3));
		
		System.out.print("Um circulo com raio de ");
		System.out.printf("%.2f",raio);
		System.out.print(" centimetros tem uma area de ");
		System.out.printf("%.2f", A );
		System.out.println(" centimetros quadrados.");
		
		System.out.print("Uma esfera com raio de ");
		System.out.printf("%.2f",raio);
		System.out.print(" centimetros tem um volume de ");
		System.out.printf("%.2f", V );
		System.out.println(" centimetros cubicos.");
		scan.close();
	}

}
