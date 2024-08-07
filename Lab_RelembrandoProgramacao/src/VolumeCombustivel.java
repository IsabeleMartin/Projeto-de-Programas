import java.util.Scanner;
public class VolumeCombustivel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double H = scan.nextDouble();
		double h = scan.nextDouble();
		double r = scan.nextDouble();
		
		double V_cilindro_tanque = 0;
		double resultado =0;
		double V_base_tanque = 0;
		
		if((r < 0) || (H < 0) || (h < 0)) {
			
			resultado = -1;
		}else {
			if(h>=r) {
				V_cilindro_tanque = Math.PI*Math.pow(r,2)*(h-r);
				V_base_tanque = (Math.PI/3.0)*Math.pow(r,2)*(3*r-r);
				
			}else {
				V_cilindro_tanque = 0;
				V_base_tanque = (Math.PI/3.0)*Math.pow(h,2)*(3*r-h);
			}
			
			resultado = V_base_tanque + V_cilindro_tanque;
		}
			
		
		System.out.printf("%.3f", resultado);
		scan.close();
	}

}
