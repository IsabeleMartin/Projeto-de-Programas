package Lab_Introducao;

import java.util.Scanner;

public class AngryBirds {

		public static void main(String[] args) {
			double velocidade, angulo, distancia, g = 9.8;
			
			Scanner scan = new Scanner(System.in);
			
			velocidade = scan.nextFloat();
			angulo = scan.nextFloat();
			double angulo_rad = 2*Math.toRadians(angulo);
			distancia = scan.nextFloat();
			
			
			double R = ((Math.pow(velocidade, 2))*Math.sin(angulo_rad))/g;
			
			
			if(Math.abs(R-distancia)<= 0.1 ) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
			//System.out.println(R);
			scan.close();
			
			
		}
}
