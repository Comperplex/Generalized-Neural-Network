package tictactoe;

public class Timer {

	public long lastTime;
	private static final double ns = 1000000000D / 60;
	private int fpsCounter = 0;

	public Timer() {
		lastTime = System.nanoTime();
	}

	public boolean canTick() {
		long now = System.nanoTime();
		if ((now - lastTime) / ns >= 1) {
			lastTime = System.nanoTime();
			fpsCounter++;
			if (fpsCounter >= 60) {
				printPerformanceInfo();
				fpsCounter = 0;
			}
			return true;
		}
		return false;
	}

	public void printPerformanceInfo() {
		System.out.println("Frames: " + fpsCounter);
	}
}
