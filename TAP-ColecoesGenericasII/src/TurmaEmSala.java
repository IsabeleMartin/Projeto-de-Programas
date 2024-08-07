
public class TurmaEmSala {
	Turma turma;
	Sala sala;
	
	TurmaEmSala(){
		turma = new Turma();
		sala = new Sala();
	}
	
	TurmaEmSala(Turma turma, Sala sala){
		this.turma = turma;
		this.sala = sala;
	}
}
