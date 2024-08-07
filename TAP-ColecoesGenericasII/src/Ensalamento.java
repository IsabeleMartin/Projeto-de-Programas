import java.util.ArrayList;
import java.util.Iterator;

public class Ensalamento {
	ArrayList<Sala> salas;
	ArrayList<Turma> turmas;
	ArrayList<TurmaEmSala> ensalamento;
	
	Ensalamento(){
		salas = new ArrayList<Sala>();
		turmas = new ArrayList<Turma>();
		ensalamento = new ArrayList<TurmaEmSala>();
	}
	
	void addSala(Sala sala) {
		if(salas.size() == 0) {
			salas.add(sala);
		}else {
			Iterator<Sala> it_sal = salas.iterator();
			Sala sal = it_sal.next();
			if(comparaSala(sal,sala)) {
				
				
			}
		}
		
		
		
		
	}
	boolean comparaSala(Sala s1, Sala s2) {
		if(s1.bloco > s2.bloco) {
			return true;
		}else if(s1.bloco < s2.bloco) {
			return false;
		}else {
			if(s1.sala > s2.sala) {
				return true;
			}else if(s1.sala < s2.sala) {
				return false;
			}else {
				if(s1.acessivel == true || s2.acessivel == false) {
					return true;
				}else if(s1.acessivel == false || s2.acessivel == true) {
					return false;
				}else {
					return true;
				}
				
			}
		}
	}
	
	void addTurma(Turma turma) {
		//função ordenada
		turmas.add(turma);
	}
	
	Sala getSala(Turma turma) {
	    Iterator<TurmaEmSala> it = ensalamento.iterator();
	    while (it.hasNext()) {
	        TurmaEmSala ensala = it.next();
	        if (ensala.turma.equals(turma)) { 
	            return ensala.sala; 
	        }
	    }
	    return null; 
	}

	
	boolean salaDisponivel(Sala sala, int horario) {
		int flag = 0;
		for(TurmaEmSala ensa : ensalamento) {
			if(ensa.sala == sala ) {
				Turma aux = ensa.turma;
				for(Integer hr : aux.horarios) {
					if(hr == horario) {
						flag = 1;
					}
				}
			}
		}
		return (flag==0?true:false);
	}
	
	boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {
		boolean flag = true;
		boolean i = true;
		for(Integer hr: horarios) {
			flag = salaDisponivel(sala,hr);
			if(flag == false) {
				i = false;
			}
		}
		return i;
	}

	boolean alocar(Turma turma, Sala sala) {
		if((turma.acessivel == true && sala.acessivel == false)||(turma.numAlunos > sala.capacidade)||(salaDisponivel(sala,turma.horarios)==false)){
			
			return false;
			
		}else {
			TurmaEmSala tur = new TurmaEmSala();
			tur.sala = sala;
			tur.turma = turma;
			ensalamento.add(tur);
			return true;
		}
	}
	
	void alocarTodas() {
	    Iterator<Turma> it_turma = turmas.iterator();
	    while (it_turma.hasNext()) {
	        Turma tur = it_turma.next(); 
	        boolean flag = false; // Mova a declaração da flag para dentro do loop das turmas
	        Iterator<Sala> it_sala = salas.iterator(); 
	        
	        while (it_sala.hasNext() && !flag) { // Use !flag em vez de flag == false
	            Sala sal = it_sala.next(); 
	            flag = alocar(tur, sal);
	        }
	    }
	}


	
	int getTotalTurmasAlocadas() {
		int i = 0;
		for(TurmaEmSala en : ensalamento) {
			if(en != null) {
				i++;
			}
		}
		return i;
	}
	
	int getTotalEspacoLivre() {
		int total = 0;
		for(TurmaEmSala en: ensalamento) {
			total += (en.sala.capacidade - en.turma.numAlunos);
			
		}
		return total;
	}
	
	String relatorioResumoEnsalamento() {
		return "Total de Salas: "+salas.size()+"\nTotal de Turmas: "+turmas.size()+"\nTurmas Alocadas: "+getTotalTurmasAlocadas()+"\nEspaços Livres: "+getTotalEspacoLivre()+"\n";
	}

	
	String relatorioTurmasPorSala() {
		StringBuilder relatorio = new StringBuilder();
	    relatorio.append(relatorioResumoEnsalamento());
	    for (Sala sala : salas) {
	        relatorio.append(String.format("\n--- Bloco %s, Sala %d (%d lugares, %s) ---\n",
	            sala.bloco, sala.sala, sala.capacidade, sala.acessivel ? "acessível" : "não acessível"));
	        for (TurmaEmSala tes : ensalamento) {
	            if (tes.sala.equals(sala)) {
	                relatorio.append(String.format(
	                    "\nTurma: %s\n" +
	                    "Professor: %s\n" +
	                    "Número de Alunos: %d\n" +
	                    "Horário: %s\n" +
	                    "Acessível: %s\n\n",
	                    tes.turma.nome,
	                    tes.turma.professor,
	                    tes.turma.numAlunos,
	                    tes.turma.getHorariosString(),
	                    tes.turma.acessivel ? "sim" : "não"
	                ));
	            }
	        }
	    }
	    return relatorio.toString();
	}

	String relatorioSalasPorTurma() {
	    StringBuilder relatorio = new StringBuilder();
	    relatorio.append(relatorioResumoEnsalamento());
	    for (Turma turma : turmas) {
	        Sala salaAlocada = getSala(turma);
	        relatorio.append(String.format(
	            "Turma: %s\n" +
	            "Professor: %s\n" +
	            "Número de Alunos: %d\n" +
	            "Horário: %s\n" +
	            "Acessível: %s\n" +
	            "Sala: %s\n",
	            turma.nome,
	            turma.professor,
	            turma.numAlunos,
	            turma.getHorariosString(),
	            turma.acessivel ? "sim" : "não",
	            salaAlocada != null ? String.format("Bloco %s, Sala %d (%d lugares, %s)",
	                salaAlocada.bloco, salaAlocada.sala, salaAlocada.capacidade,
	                salaAlocada.acessivel ? "acessível" : "não acessível") : "SEM SALA"
	        ));
	    }
	    return relatorio.toString();
	}

	
}
