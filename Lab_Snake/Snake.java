/*
 * Copyright (c) 2016, IComp/UFAM. All rights reserved.
 */

import java.util.*;
import java.awt.*;

/**
 * A classe {@code Snake} representa o Jogo Snake, gerando uma arena, comidas e
 * uma cobra que é composta por um conjunto de segmentos (usando a classe
 * {@code LinkedList<java.awt.Point>}).
 * <p>
 * Caso alguma janela tenha sido passada usando o método {@code setSaida} o
 * jogo será pintado na janela. Caso algum jogador tenha sido passado usando o
 * método {@code setJogador}, este será usado para decidir o próximo passo da
 * cobra. Caso nenhum jogador tenha sido setado, a janela passada será usada
 * para ler do teclado a próxima ação da cobra. Este processo é repetido várias
 * vezes por segundo.
 * <p>
 * Desta forma, esta classe pode ser usada de três formas diferentes:
 * <ol>
 *   <li>
 *     Para jogar na janela usando teclado:
 *     <blockquote><pre>
 *       Snake jogo = new Snake(30, 30);
 *       SnakeMain janela = new SnakeMain(jogo);
 *       jogo.setSaida(janela);
 *       jogo.setJogador(null);
 *       jogo.inicia();</pre></blockquote>
 *   </li>
 *   <li>
 *     Para jogar na janela usando um jogador implementado:
 *     <blockquote><pre>
 *       Snake jogo = new Snake(30, 30);
 *       SnakeJogador jogador = new SnakeJogador(jogo);
 *       SnakeMain janela = new SnakeMain(jogo);
 *       jogo.setSaida(janela);
 *       jogo.setJogador(jogador);
 *       jogo.inicia();</pre></blockquote>
 *   </li>
 *   <li>
 *     Para jogar sem janela usando um jogador implementado (correção do 
 *     trabalho):
 *     <blockquote><pre>
 *       Snake jogo = new Snake(30, 30);
 *       SnakeJogador jogador = new SnakeJogador(jogo);
 *       jogo.setSaida(null);
 *       jogo.setJogador(jogador);
 *       jogo.inicia();</pre></blockquote>
 *   </li>
 * </ol>
 * <p>
 * Caso alguma comida tenha sido encontrada pela cobra, ela cresce de tamanho.
 * Caso a cobra colida com as bordas da arena, ou caso ela colida com algum
 * segmento dela mesma, o jogo termina.
 * 
 * @author Horacio
 */

public class Snake {
    private int largura, altura;
    private SnakeMain saida;
    private SnakeJogador jogador;
    
    private LinkedList<Point> segmentos;
    private char direcaoAtual;
    private Point comida;
    
    private boolean rodando;
    private int tamSegmento;
    private int delay;
    private int totalComida;

    private Random rng;
    
    /**
     * Cria um novo jogo passando a largura e a altura (em número de células)
     * da arena. A cada nova instância, uma semente aleatória será usada,
     * fazendo um jogo ser diferente do outro (em termos de posicionamento das
     * comidas).
     * 
     * @param largura largura da arena.
     * @param altura  altura da arena.
     */
    public Snake(int largura, int altura) {
        this(largura, altura, 0);
    }

    /**
     * Cria um novo jogo passando a largura e a altura (em número de células)
     * da arena e uma semente que será usada para gerar os números aleatórios.
     * Jogos com sementes iguais terão o mesmo posicionamento das comidas,
     * facilitando a comparação de algoritmos diferentes em instâncias iguais
     * do jogo.
     * 
     * @param largura largura da arena.
     * @param altura  altura da arena.
     * @param semente
     */
    public Snake(int largura, int altura, int semente) {
        this.largura = largura > 5 ? largura : 5;
        this.altura  = altura > 5 ? altura : 5;
        
        segmentos    = new LinkedList<Point>();
        direcaoAtual = 'D';
        
        rodando      = true;
        tamSegmento  = 25;
        delay        = 80;
        
        rng = (semente > 0) ? new Random(semente) : new Random();
        
        // Inicializa a cobra com alguns segmentos e adiciona comida
        for (int i=0; i<5; i++) segmentos.addFirst(new Point(i, altura/2));
        addComida();
    }
    
    /**
     * Acessa a largura da arena (em número de células).
     * @return largura da arena.
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Acessa a altura da arena (em número de células).
     * @return altura da arena.
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Acessa a largura da arena (em número de pixels).
     * @return largura da arena.
     */
    public int getLarguraPixels() {
        return largura*tamSegmento;
    }

    /**
     * Acessa a altura da arena (em número de pixels).
     * @return altura da arena.
     */
    public int getAlturaPixels() {
        return altura*tamSegmento;
    }

    /**
     * Seta a saída do jogo (janela). A saída será usada para pintar o jogo e,
     * caso o jogador não tenha sido setado, para pegar a entrada do teclado.
     * 
     * @param saida janela para pintar o jogo.
     */
    public void setSaida(SnakeMain saida) {
        this.saida = saida;
    }

    /**
     * Seta o jogador que irá controlar a cobra. Caso o jogador não tenha sido
     * setado, ou tenha sido setado para {@code null}, o teclado da saída será
     * usado para controlar a cobra.
     * 
     * @param jogador jogador que irá controlar a cobra.
     */
    public void setJogador(SnakeJogador jogador) {
        this.jogador = jogador;
    }
    
    /**
     * Acessa a lista de segmentos da cobra. Uma cobra é representada por uma
     * lista (classe {@code LinkedList}) de segmentos (classe
     * {@code java.awt.Point}). Este método retorna esta lista de segmentos.
     * 
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html">java.util.LinkedList</a>
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html">java.awt.Point</a>
     * @return lista de segmentos da cobra.
     */
    public LinkedList<Point> getSegmentos() {
        return segmentos;
    }

    /**
     * Acessa a direção atual da cobra ('C'ima, 'D'ireita, 'B'aixo ou
     * 'E'squerda).
     * 
     * @return direção atual da cobra.
     */
    public char getDirecaoAtual() {
        return direcaoAtual;
    }
    
    /**
     * Acessa a posição da comida na arena. Uma comida é representada por um
     * ponto (classe <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html">
     * {@code java.awt.Point}</a>). A qualquer momento, existirá uma (e apenas
     * uma) comida na arena.
     * 
     * @return posição da comida na arena.
     */
    public Point getComida() {
        return comida;
    }
    
    /**
     * Adiciona uma nova comida na arena.
     */
    private void addComida() {
        comida = new Point(rng.nextInt(largura), rng.nextInt(altura));
        
        // Gera outra comida, enquanto a atual cair em algum segmento da cobra
        while (segmentos.contains(comida))
            comida = new Point(rng.nextInt(largura), rng.nextInt(altura));
      //  	System.out.println(comida);
    }
    
    /**
     * Acessa o total de comida.
     * @return total de comida.
     */
    public int getTotalComida() {
        return totalComida;
    }
    
    /**
     * Verifica se uma determinada célula da arena está livre. Uma célula
     * estará livre se ela está dentro dos limites da arena e se não houver
     * nenhum segmento da cobra nela.
     * 
     * @param x posição x da célula.
     * @param y posição y da célula.
     * @return se a célula está livre ou não.
     */
    public boolean isCelulaLivre(int x,  int y) {
        // Verifica se colidiu com as bordas da arena
        if (x < 0 || x >= largura || y < 0 || y >= altura) return false;
        
        // Verifica se colidiu com a cobra
        for (Point segmentoAtual : segmentos)
            if (segmentoAtual.x == x && segmentoAtual.y == y) return false;
        
        return true;
    }

    /**
     * Faz a cobra andar um segmento na direção indicada pelo parâmetro.
     * 
     * @param  direcao direção do próximo passo da cobra ('C'ima, 'D'ireita,
     *                 'B'aixo ou 'E'squerda).
     *                 
     * @return verdadeiro se foi um passo válido ou falso caso contrário (houve
     *         alguma colisão).
     */
    private boolean anda(char direcao) {
        if      (direcao == 'C' && direcaoAtual != 'B') direcaoAtual = 'C'; // Cima
        else if (direcao == 'D' && direcaoAtual != 'E') direcaoAtual = 'D'; // Direita
        else if (direcao == 'B' && direcaoAtual != 'C') direcaoAtual = 'B'; // Baixo
        else if (direcao == 'E' && direcaoAtual != 'D') direcaoAtual = 'E'; // Esquerda

        // Posição da nova cabeça da cobra
        Point novoSegmento = (Point) segmentos.getFirst().clone();
        if      (direcaoAtual == 'C') novoSegmento.y--;
        else if (direcaoAtual == 'D') novoSegmento.x++;
        else if (direcaoAtual == 'B') novoSegmento.y++;
        else if (direcaoAtual == 'E') novoSegmento.x--;
        
        //System.out.println(novoSegmento + "  ");
        
        // Verifica se a cabeca colidiu com as bordas da arena ou com a cobra
        if (!isCelulaLivre(novoSegmento.x, novoSegmento.y)) return false;

        // Adiciona um novo segmento à cobra (no topo, cabeça)
        segmentos.addFirst(novoSegmento);
        
        // Verifica se comeu alguma comida
        if (novoSegmento.equals(comida)) {
            addComida();
            totalComida++;
        }
        else segmentos.removeLast();

        return true;
    }

    /**
     * Pinta o jogo na janela.
     * @param g aonde o jogo será pintado.
     */
    public void paintWindow(Graphics g) {
        // Pinta o fundo branco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getLarguraPixels()+1, getAlturaPixels()+1);
        
        // Pinta a cobra
        int cor = 100;
        for (Point segmentoAtual : segmentos) {
            if (segmentoAtual == segmentos.getFirst()) g.setColor(Color.BLACK);
            else {
                Color corSegmento = new Color(cor, cor, cor);
                cor = cor < 220 ? cor + 20 : cor; 
                g.setColor(corSegmento);
            }
            g.fillRect(segmentoAtual.x*tamSegmento+1, segmentoAtual.y*tamSegmento+1, tamSegmento-1, tamSegmento-1);
        }
        
        // Pinta a comida
        g.setColor(Color.RED);
        g.fillOval(comida.x*tamSegmento+1, comida.y*tamSegmento+1, tamSegmento-2, tamSegmento-2);
        
        g.drawString(Integer.toString(totalComida), 3, getAlturaPixels()-3);
        if (!rodando) g.drawString("Fim!", getLarguraPixels()-28, getAlturaPixels()-3);
    }
    
    /**
     * Este método será executado para iniciar o jogo e só irá retornar quando
     * o jogo terminar (a cobra colidiu com alguma coisa).
     * <p>
     * A cada 'tick' do jogo, este método irá:
     * <ul>
     *   <li>executar o método {@code getDirecao} da janela ou do jogador para
     *       perguntar qual a direção do próximo passo da cobra;</li>
     *   <li>fazer a cobra andar um segmento na direção indicada;</li>
     *   <li>pintar o novo estado do jogo (se tiver uma janela de saída);</li>
     *   <li>esperar um tempo para o próximo 'tick'</li>
     * </ul>
     * 
     * @see SnakeJogador
     */
    public void inicia() {
        while (rodando) {
            char direcao = (jogador != null ? jogador.getDirecao() : saida.getDirecao());
            
            rodando = anda(direcao);
            
            if (saida != null) {
                saida.repaint();
                
                // Sleep não é a forma mais recomendada para um loop de jogo com muitos
                // frames por segundo, mas é mais do que suficiente para o jogo atual.
                try { Thread.sleep(delay); } catch (Exception e) {}
            }
        }
        
        System.out.println("Total de comida: " + totalComida);
    }
    
}
