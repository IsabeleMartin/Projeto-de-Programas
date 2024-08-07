/*
 * Copyright (c) 2016, IComp/UFAM. All rights reserved.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A classe {@code SnakeMain} irá gerar uma instância do jogo Snake e, 
 * opcionalmente, servir de janela para a saída do jogo. Poderá também ser
 * usada como entrada (leitura do teclado).
 * 
 * @author Horácio
 */

public class SnakeMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1L;
	private Snake  jogo;
    private JPanel panel;
    private int    ultimaTecla;

    /**
     * Se o construtor da classe for executado, então a saída do jogo será pela
     * janela. O construtor irá criar a janela, colocar um painel dentro dela
     * para a pintura do jogo e, por fim, ficará ouvindo o teclado para o caso
     * de o jogo pedir por direções.
     * 
     * @param jogo jogo a ser pintado na janela.
     */
    public SnakeMain(Snake jogo) {
        super("Snake");

        this.jogo = jogo;
        this.panel = new JPanel();

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(jogo.getLarguraPixels(), jogo.getAlturaPixels()));
        pack();
        setResizable(false);
        panel.setBounds(0, 0, jogo.getLarguraPixels(), jogo.getAlturaPixels());
        panel.addKeyListener(this);
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        add(panel);
        setVisible(true);
    }

    /**
     * Executado sempre que há a necessidade de se pintar a janela.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html">javax.swing.JFrame</a>
     */
    public void paint(Graphics g) {
        super.paint(g);
        jogo.paintWindow(panel.getGraphics());
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * Executado sempre que uma tecla é pressionada.
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyListener.html">java.awt.event.KeyListener</a>
     */
    public void keyPressed(KeyEvent e) {
        ultimaTecla = e.getKeyCode();
    }

    /**
     * Executado pelo método {@link Snake#inicia()} a cada 'tick' do jogo para
     * perguntar qual a próxima direção da cobra. Responde com base na última
     * tecla pressionada pelo usuário.
     * 
     * @return a próxima direção da cobra.
     */
    public char getDirecao() {
        if      (ultimaTecla == KeyEvent.VK_UP)    return 'C';  // Cima
        else if (ultimaTecla == KeyEvent.VK_RIGHT) return 'D';  // Direita
        else if (ultimaTecla == KeyEvent.VK_DOWN)  return 'B';  // Baixo
        else if (ultimaTecla == KeyEvent.VK_LEFT)  return 'E';  // Esquerda
        else return 'N'; // Desconhecido
        
    }

    /**
     * Método main.
     * @param args
     */
    public static void main(String[] args) {

        Snake jogo = new Snake(30, 20);
      /*  
        // Para jogar na janela usando teclado
        SnakeMain janela = new SnakeMain(jogo);
        jogo.setSaida(janela);
        jogo.setJogador(null);
        jogo.inicia();
		*/
     /*   

        // Para jogar na janela usando o jogador implementado
        SnakeJogador jogador = new SnakeJogador(jogo);
        SnakeMain janela = new SnakeMain(jogo);
        jogo.setSaida(janela);
        jogo.setJogador(jogador);
        jogo.inicia();
 */
        // Para jogar sem janela usando o jogador implementado (correção do trabalho) 
        SnakeJogador jogador = new SnakeJogador(jogo);
        SnakeMain janela = new SnakeMain(jogo);
        jogo.setSaida(janela);
        jogo.setJogador(jogador);
        jogo.inicia();

       

    }

    // A sobreposição dos métodos abaixo é obrigatória (interface KeyListener)
    public void keyReleased(KeyEvent arg0) {}
    public void keyTyped(KeyEvent arg0) {}
}
