import java.util.Scanner;

public class ContaEnergia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int consumo = scan.nextInt();
		char type = scan.next().charAt(0);
		double valor = 0;
		
		if((consumo > 0) && ( (type == 'R') || (type == 'I') || (type == 'C'))){
			if(type == 'R') {
				if(consumo <= 500) {
					valor = consumo*0.40;
					
				}else {
					valor = consumo*0.65;
					
				}
				
			}else if(type == 'I') {
				if(consumo <= 1000) {
					valor = consumo*0.55;
					
				}else {
					valor = consumo*0.60;
					
				}
			}else{
				if(consumo <= 5000) {
					valor = consumo*0.55;
					
				}else {
					valor = consumo*0.60;
					
				}
			}
		
		}else {
			valor = -1;
		}
		
		System.out.printf("%.2f\n", valor);
		scan.close();
	}

}
