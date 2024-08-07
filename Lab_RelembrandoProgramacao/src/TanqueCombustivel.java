import java.util.Scanner;

public class TanqueCombustivel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double raio = scan.nextDouble();
		double A_ar = scan.nextDouble();
		double Op = scan.nextDouble();
		double resposta = 0;
		
		if(Op == 2) {
			resposta = ((4.0/3.0)*Math.PI*Math.pow(raio, 3)) -((Math.PI/3.0)*Math.pow(A_ar,2)*(3*raio - A_ar)) ;
		}else if(Op == 1) {
			resposta = (Math.PI/3.0)*Math.pow(A_ar,2)*(3*raio - A_ar);
		}

		System.out.printf("%.4f",resposta);
		
		scan.close();
		
	}

}
