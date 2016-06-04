package tictactoe;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI {
	public static final int GUI_WIDTH = 500;
	public static final int GUI_HEIGHT = 500;

	private JFrame frame;
	private DrawPanel drawPanel;
	private boolean running;
	private Screen screen;

	public GUI() {
		frame = new JFrame("Test");

		drawPanel = new DrawPanel();
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setResizable(false);
		frame.setSize(GUI_WIDTH, GUI_HEIGHT);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		this.screen = new Screen(GUI_WIDTH, GUI_HEIGHT);

	}

	public void update() {
		screen.update();
		frame.repaint();
	}

	public synchronized void start() {
		running = true;
		while (running) {
			update();
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
//			BufferedImage image = new BufferedImage(GUI_WIDTH, GUI_HEIGHT, BufferedImage.TYPE_INT_RGB);
//			Graphics g2 = image.getGraphics();
//			g2.fillRect(10, 10, 10, 10);
//			g.drawImage(image, 0, 0, null);
			
			g.drawImage(screen.getImage(), 0, 0, null);	
		}
	}
}
