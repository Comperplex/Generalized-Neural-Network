package tictactoe;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TicTacToe implements Runnable {
	public static final int GUI_WIDTH = 498;
	public static final int GUI_HEIGHT = 498;

	private JFrame frame;
	private DrawPanel drawPanel;
	private boolean running;
	private Screen screen;
	private Timer timer;
	
	private GameBoard board;
	private static final int MAX_FAIL_COUNT = 3;

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
	
	public TicTacToeResult runGame(Player pO, Player pX){ //pO must be of player type O and pX must be of player type X
		TicTacToeResult result = new TicTacToeResult();
		
		while(!board.isGameOver()){ //do this while the game is not over
			TurnResult currentResult = board.runTurn(pO, pX); //THIS IS WHERE THE TURN HAPPENS! pO and pX do different things depending on their player type
			result.addGameTurn(currentResult);
		}
		result.setFinalState(board.getGameState());
		return result; 
	}

	public void update() {
		screen.update(board.getBoard());
		frame.repaint();
	}

	public synchronized void start() {
		running = true;
		timer = new Timer();
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}
	
	public GameBoard getBoard(){
		return board; 
	}

	@Override
	public void run() {
		timer = new Timer();
		while (running) {
			if(timer.canTick()){
				update();
			}
		}
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
}
