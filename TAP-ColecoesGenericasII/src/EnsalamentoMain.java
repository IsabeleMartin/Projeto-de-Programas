public class EnsalamentoMain {

    public static void main(String[] args) {
    	
    
    	Ensalamento e1 = new Ensalamento();
    	
    	Sala s1 = new Sala(2, 102, 80, true);
    	e1.addSala(s1);
    	
    	Turma t1 = new Turma("Organização de Computadores", "Andrew S. Tanenbaum", 70, true);
    	t1.addHorario(7);
    	t1.addHorario(21);
    	t1.addHorario(35);
    	e1.addTurma(t1);
    	
    	Sala s2 = new Sala(2, 202, 100, false);
    	e1.addSala(s2);
    	e1.alocar(t1, s2);
    	
    	Sala s3 = new Sala(2, 301, 50, true);
    	e1.addSala(s3);
    	e1.alocar(t1, s3);
    	e1.alocar(t1, s1);
    	//System.out.println(e1.getSala(t1));
    	System.out.println(e1.relatorioSalasPorTurma());
    	System.out.println();
    	System.out.println(e1.getSala(t1).getDescricao());

    }
}