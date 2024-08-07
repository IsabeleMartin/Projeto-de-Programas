import java.util.Scanner;

public class AprovacaoDisciplina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	    int presencas[] = new int[100];
	    int presenca = 0;
	    double notas[] = new double[100];
	    double nota = 0.0;
	    int carga_h = 0, i = 0, app = 0, rpf = 0, rpn = 0;
	    
	    nota = scan.nextDouble();
	    
	    while(nota != -1.0) {
	    	notas[i] = nota;
	    	nota = scan.nextDouble();
	    	i++;
	    }
	    
	    presenca = scan.nextInt();
	    i=0;
	    while(presenca != -1) {
	    	presencas[i] = presenca;
	    	presenca = scan.nextInt();
	    	i++;
	    }
	    
	    carga_h = scan.nextInt();
	    
	    
	    int j = 0;
	    while(i>0) {
	    	double percen = (double)presencas[j]/carga_h;
	    	if(notas[j] >= 5.0 && percen >= 0.75) {
	    		app++;
	    	}
	    	else if(notas[j]>=5.0 && percen<0.75) {
	    		rpf++;
	    	}else if(notas[j]<5.0 && percen>0.75) {
	    		rpn++;
	    	}else {
	    		rpf++;
	    	}
	    	
	    	i--;
	    	j++;
	    }
	    
	    System.out.println(app +" "+ rpn+" "+rpf);
		scan.close();
	}
	    
}

//10,0 10,0 9,0 -1 44 45 46 -1 60
//7,5 6,0 4,0 -1 45 60 30 -1 60
//5,0 5,0 5,0 -1 45 30 60 -1 60
//4,0 4,0 4,0 -1 60 60 60 -1 60

//7,5 6,0 4,0 8,0 9,0 7,0 6,5 5,5 6,0 7,5 -1 45 60 30 60 45 60 45 60 30 45 -1 60






