package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TicTacToe {
	public static final int GUI_WIDTH = 498;
	public static final int GUI_HEIGHT = 498;

	private JFrame frame;
	private DrawPanel drawPanel;
	private boolean running;
	private Screen screen;
	private Timer timer;
	
	private GameBoard board; 

	@SuppressWarnings("static-access")
	public TicTacToe() {
		frame = new JFrame("Tic Tac Toe Screen");

		drawPanel = new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(GUI_HEIGHT, GUI_WIDTH);
		frame.setResizable(true);
		
		this.screen = new Screen(frame);
		board = new GameBoard();
	}

	public void update() {
		screen.update(board.getBoard());
		frame.repaint();
	}

	public synchronized void start() {
		running = true;
		timer = new Timer();
		while (running) {
			if(timer.canTick()){
				update();
			}
		}
	}

	public synchronized void stop() {
		running = false;
	}

	class DrawPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.drawImage(screen.getImage(), 0, 0, null);	
		}
	}
	
	public GameBoard getBoard(){
		return board; 
	}
}
