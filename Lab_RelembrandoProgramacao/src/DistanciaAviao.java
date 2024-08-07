import java.util.Scanner;

public class DistanciaAviao {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matriz = {
				{-1, 111, 222, 333, 444, 555, 666, 777},
				{111,  0,   2,  11,   6,  15,  11,   1},
				{222,  2,   0,   7,  12,   4,   2,  15},
				{333, 11,   7,   0,  11,   8,   3,  13},
				{444,  6,  12,  11,   0,  10,   2,   1},
				{555, 15,   4,   8,  10,   0,   5,  13},
				{666, 11,   2,   3,   2,   5,   0,  14},
				{777,  1,  15,  13,   1,  13,  14,   0}};
		int vector[] = new int[100];
		int coletor = 0, i = 0, k = 0, valor = 0;
		int distancia = 0, linha=0, coluna=0;
		
		coletor = scan.nextInt();
		
		while(coletor != -1) {
			
			vector[i] = coletor;
			coletor = scan.nextInt();
			//System.out.print(vector[i]+ " - ");
			i++;
		}
		
		for(int j = 0; j < i; j++) {
			vector[j] = vector[j]/111;
			//System.out.print(vector[j]+ " ");
		}
		//System.out.println();
		
		while(k < i-1) {
			
			linha = vector[k];
			coluna = vector[k+1];
		//	System.out.print(linha+ " " + coluna + " ");
			valor = matriz[linha][coluna];
		//	System.out.println(valor);
			distancia += valor;
			k++;
		}
		
		System.out.println(distancia);		
		
		scan.close();
		

	}

}
