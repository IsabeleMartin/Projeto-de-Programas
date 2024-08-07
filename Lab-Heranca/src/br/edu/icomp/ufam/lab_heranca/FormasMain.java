package br.edu.icomp.ufam.lab_heranca;
import java.util.Random;

public class FormasMain {
    public static void main(String[] args) {
    	Random random = new Random();
        FormaGeometrica lista[] = new FormaGeometrica[100];
        int j = 0;
        int x = 0, y=0,r=0,l = 0;
        
        for(int i = 0; i < 10; i++) {
        	x = random.nextInt(100);
        	y = random.nextInt(100);
        	r = random.nextInt(100);
        	l = random.nextInt(100);
        	
        	Circulo circulo = new Circulo(x, y, r);
            Retangulo retangulo = new Retangulo(r, x, y, l);
            Quadrado quadrado = new Quadrado(r, x, y);
            
            lista[j] = circulo;
            lista[j+1]= retangulo;
            lista[j+2]= quadrado;
            
            j+=3;
        	
        }
        for(int h = 0; h < 30; h++) {
        	System.out.println(lista[h]);
        	System.out.println();
        }
        
        
        
    }
}

