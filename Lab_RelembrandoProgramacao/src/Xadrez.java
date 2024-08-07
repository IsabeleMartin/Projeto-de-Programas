import java.util.Scanner;

public class Xadrez {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cont = num;
		
		while(cont > 0) {
			for(int i = 0; i< num ; i++) {
				System.out.print('*');
				System.out.print(' ');
			}
			System.out.print("\n");
			for(int i = 0; i< num ; i++) {
				System.out.print(' ');
				System.out.print('*');
			}
			System.out.print("\n");
			cont=cont-2;
		}
		
		scan.close();
	}

}