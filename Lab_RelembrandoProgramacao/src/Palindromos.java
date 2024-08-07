import java.util.Scanner;

public class Palindromos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String linha = scan.nextLine();
		int tam = 0, i = 0, flag = 0;
		
		linha = linha.toUpperCase();
		linha = linha.replace(" ", "");
		tam = linha.length()-1;
		//System.out.println(tam);
		
		while((i != tam) && (i <= tam) && flag != 1) {
			//System.out.println(i + " " + tam);
			if( linha.charAt(i) != linha.charAt(tam)) {
				flag = 1;
				
			}
			i++;
			tam--;
		}
		
		if(flag == 1) {
			System.out.println(linha+" "+ 0);
		}else {
			System.out.println(linha+" "+1);
		}
		
		
		
		scan.close();
	}

}
