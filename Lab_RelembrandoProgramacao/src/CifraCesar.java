import java.util.Scanner;

public class CifraCesar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		String frase = scan.nextLine(); // pega o espaço
		String codificado = "";
		char cifrado = 0;
		int i = 0;
		int tam = frase.length();
		
		while(i < tam) {
			if(frase.charAt(i)>=32 && frase.charAt(i) <= 57) {
				codificado = codificado + frase.charAt(i);
			}
			
			
			else if(frase.charAt(i) >= 65 && frase.charAt(i) <= 90 ) {
				if(frase.charAt(i) + num > 90) {
					cifrado = (char) ((frase.charAt(i)+num));
					codificado = codificado + cifrado;
				//	System.out.println(codificado + " " + meuchar);
				}
				
				
				
				
			}else if(frase.charAt(i) >= 97 && frase.charAt(i) <= 122) {
				cifrado = (char)(((frase.charAt(i) - 'a' + num) % 26) + 'A');
				codificado = codificado + cifrado;
				//System.out.println(codificado + " - " + meuchar);
			}
			//cifrado = (char) i;
			//System.out.print(cifrado + " " + i + "; ");
			i++;
		}
		
		
		
		
		System.out.println(codificado.substring(1));
		
		scan.close();
	}

}
