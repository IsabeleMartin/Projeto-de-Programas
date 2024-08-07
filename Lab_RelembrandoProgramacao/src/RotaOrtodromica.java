import java.util.Scanner;

public class RotaOrtodromica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double R = 6371;
		Scanner scan = new Scanner(System.in);
		
		double t1 = scan.nextDouble();
		double t1_rad = Math.toRadians(t1);
		double g1 = scan.nextDouble();
		double g1_rad = Math.toRadians(g1);
		double t2 = scan.nextDouble();
		double t2_rad = Math.toRadians(t2);
		double g2 = scan.nextDouble();
		double g2_rad = Math.toRadians(g2);
		
		
		double angulo = Math.sin(t1_rad)*Math.sin(t2_rad) + (Math.cos(t1_rad)*Math.cos(t2_rad)* Math.cos(g1_rad-g2_rad));
		//System.out.println(angulo);
		
		
		double d = (R * Math.acos(angulo));
		
		System.out.printf("A distancia entre os pontos (%.6f, %.6f) e (%.6f, %.6f) e de %.2f km", t1, g1, t2, g2, d);		scan.close();
	
	}

}
