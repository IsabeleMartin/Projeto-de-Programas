import java.awt.Point;
import java.util.*;

/**
 * Classe de exemplo para a implementação de um Jogador para o Jogo Snake.
 * Nesta implementação, a próxima direção da cobra é escolhida aleatoriamente
 * entre as direções possíveis (que não geram colisões).
 * <p>
 * Use esta classe como base inicial para a sua solução do jogo. Basicamente
 * você precisará reimplementar o método {@code getDirecao}.
 * 
 * @author Horácio
 */

public class SnakeJogador {
    private Snake jogo;
    
    /**
     * Cria um novo jogador para o jogo passado como parâmetro.
     * @param jogo jogo snake.
     */
    public SnakeJogador(Snake jogo) {
        this.jogo = jogo;
    }

    /**
     * Executado pelo método {@link Snake#inicia()} a cada 'tick' do jogo para
     * perguntar qual a próxima direção da cobra ('C'ima, 'D'ireita, 'B'aixo,
     * 'E'squerda ou 'N'enhum).
     * 
     * @return a próxima direção da cobra.
     */
    public char getDirecao() {
        /*
         * IMPLEMENTE AQUI A SUA SOLUÇÃO PARA O JOGO
         */
        
        ArrayList<Character> possiveisDirecoes = new ArrayList<Character>(4);
        Point cabeca = jogo.getSegmentos().getFirst();
        
        Point locComida = jogo.getComida();
        System.out.println("localizacao da comida = "+ locComida );
        System.out.println("localizacao da cabeca = "+ cabeca + "   Estado = " + posEstado(cabeca,locComida));
        
        
        
        // func (onde a comida está e onde eu estou )
        if(posEstado(cabeca, locComida) == 1) {
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C');  // Cima
        	else if(jogo.isCelulaLivre(cabeca.x-1, cabeca.y)) possiveisDirecoes.add('E'); // Esquerda
        }
        else if(posEstado(cabeca, locComida) == 2) {
        	if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y)) possiveisDirecoes.add('D'); // Direita
        	else if(jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B'); // Baixo

        }
        else if(posEstado(cabeca, locComida) == 3) {
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B'); // Baixo
        	else if(jogo.isCelulaLivre(cabeca.x-1, cabeca.y)) possiveisDirecoes.add('E'); // Esquerda

        }
        else if(posEstado(cabeca, locComida) == 4) {
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C'); // Cima
        	else if(jogo.isCelulaLivre(cabeca.x+1, cabeca.y)) possiveisDirecoes.add('D'); // Direita
        	else possiveisDirecoes.add(movPossivel(cabeca));

        }else if(posEstado(cabeca, locComida) == 5) {
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1) && !jaPassou(cabeca,locComida)) possiveisDirecoes.add('B'); // Cima
        	else {
        		if(jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B');
        		else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C');
        		else possiveisDirecoes.add(movPossivel(cabeca));
        	}
        }else if(posEstado(cabeca, locComida) == 6) {
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1) && !jaPassou(cabeca,locComida)) possiveisDirecoes.add('C'); // Cima
        	else {
        		if(jogo.isCelulaLivre(cabeca.x+1, cabeca.y)) possiveisDirecoes.add('D');
        		else if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y)) possiveisDirecoes.add('E');
        		else possiveisDirecoes.add(movPossivel(cabeca));
        	}
        }else if(posEstado(cabeca, locComida) == 7) {
        	if(jogo.isCelulaLivre(cabeca.x-1, cabeca.y) && !jaPassou(cabeca,locComida)) possiveisDirecoes.add('E'); // Direita
        	else {
        		if(jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B');
        		else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C');
        		else possiveisDirecoes.add(movPossivel(cabeca));
        	}

        }else if(posEstado(cabeca, locComida) == 8) {
        	if(jogo.isCelulaLivre(cabeca.x+1, cabeca.y) && !jaPassou(cabeca,locComida)) possiveisDirecoes.add('D'); // Direita
        	else {
        		if(jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) possiveisDirecoes.add('B');
        		else if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) possiveisDirecoes.add('C');
        		else possiveisDirecoes.add(movPossivel(cabeca));
        	}


        }
        
        System.out.println(possiveisDirecoes);
        
    // Não existe mais nenhuma direção disponível
        if (possiveisDirecoes.size() == 0) return 'N';
       
        int ultima = possiveisDirecoes.size();
        
        return possiveisDirecoes.get(ultima-1);
       
       
        
        
    }
    
    public int posEstado(Point cabeca, Point comida) {
    	if(cabeca.x > comida.x && cabeca.y > comida.y) {
    		return 1; // abaixo e a direita
    	}else if(cabeca.x < comida.x && cabeca.y < comida.y) {
    		 return 2; // acima e a esquerda
    	}else if(cabeca.x > comida.x && cabeca.y < comida.y) {
    		 return 3; // acima e a direita
    	}else if(cabeca.x < comida.x && cabeca.y > comida.y){
    		return 4; // abaixo e a esquerda 
    	}else if(cabeca.x == comida.x && cabeca.y < comida.y) {
    		return 5;//aqui
    	}else if(cabeca.x == comida.x && cabeca.y > comida.y) {
    		return 6;
    	}else if(cabeca.x > comida.x && cabeca.y == comida.y) {
    		return 7;
    	}else if(cabeca.x < comida.x && cabeca.y == comida.y)  {
    		return 8;//aqui
    	}
    	return 9;
    }
    
    public boolean jaPassou(Point cabeca, Point comida) {
    	if(cabeca.x == comida.x && cabeca.y < comida.y && jogo.getDirecaoAtual() == 'C') {
    		return true;//aqui
    	}else if(cabeca.x == comida.x && cabeca.y > comida.y && jogo.getDirecaoAtual() == 'B') {
    		return true;
    	}else if(cabeca.x > comida.x && cabeca.y == comida.y && jogo.getDirecaoAtual() == 'D') {
    		return true;
    	}else if(cabeca.x < comida.x && cabeca.y == comida.y && jogo.getDirecaoAtual() == 'E')  {
    		return true;
    	}else return false;
    }
    
   public char movPossivel(Point cabeca) {
	   if (jogo.isCelulaLivre(cabeca.x, cabeca.y-1)) return 'C'; // Cima
       if (jogo.isCelulaLivre(cabeca.x+1, cabeca.y)) return 'D'; // Direita
       if (jogo.isCelulaLivre(cabeca.x, cabeca.y+1)) return 'B'; // Baixo
       if (jogo.isCelulaLivre(cabeca.x-1, cabeca.y)) return 'E'; // Esquerda
       else return 'N';
   }
    
    
}