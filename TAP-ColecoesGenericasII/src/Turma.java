import java.util.ArrayList;
import java.util.Iterator;

public class Turma {
	String nome;
	String professor;
	int numAlunos;
	boolean acessivel;
	ArrayList<Integer> horarios;
	
	Turma(){
		nome = "";
		professor = "";
		numAlunos = 0;
		acessivel = false;
		horarios = new ArrayList<Integer>();
	}
	
	Turma(String nome, String professor, int numAlunos, boolean acessivel){
		this.nome = nome;
		this.professor = professor;
		this.numAlunos = numAlunos;
		this.acessivel = acessivel;
		this.horarios = new ArrayList<Integer>();
	}
	
	void addHorario(int horario) {
		
		this.horarios.add(horario);
	}
	
	String getHorariosString() {
	    String frase = "";
	    Iterator<Integer> iterator = horarios.iterator();
	    while(iterator.hasNext()) {
	        int it = iterator.next();
	        if(it < 8) {
	            frase += "segunda ";
	        } else if(it < 15) {
	            frase += "terça ";
	        } else if(it < 22) {
	            frase += "quarta ";
	        } else if(it < 29) {
	            frase += "quinta ";
	        } else if(it < 36) {
	            frase += "sexta ";
	        }
	        if(it == 1 || it == 8 || it == 15 || it == 22 || it == 29) {
	            frase += "8hs, ";
	        } else if(it == 2 || it == 9 || it == 16 || it == 23 || it == 30) {
	            frase += "10hs, ";
	        } else if(it == 3 || it == 10 || it == 17 || it == 24 || it == 31) {
	            frase += "12hs, ";
	        } else if(it == 4 || it == 11 || it == 18 || it == 25 || it == 32) {
	            frase += "14hs, ";
	        } else if(it == 5 || it == 12 || it == 19 || it == 26 || it == 33) {
	            frase += "16hs, ";
	        } else if(it == 6 || it == 13 || it == 20 || it == 27 || it == 34) {
	            frase += "18hs, ";
	        } else if(it == 7 || it == 14 || it == 21 || it == 28 || it == 35) {
	            frase += "20hs, ";
	        }
	    }
	    frase = frase.substring(0, frase.length() - 2);
	    return frase;
	}


	String getDescricao() {
		
		return "Turma: "+nome+"\nProfessor: "+professor+"\nNúmero de Alunos: "+numAlunos+"\nHorário: "+getHorariosString()+"\nAcessível: "+((acessivel)?"sim":"não");
	}
	
}

