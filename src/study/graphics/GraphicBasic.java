package study.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public abstract class GraphicBasic extends JFrame implements Runnable {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	public Canvas canvas = new Canvas();

	public GraphicBasic() {
		// # Setting Canvas
		canvas.setBackground(Color.BLACK);
		add(canvas);

		// # Setting JFrame
		int x = WIDTH; // getWidth() / 2 - WIDTH / 2;
		int y = HEIGHT / 4; // getHeight() / 2 - HEIGHT / 2;
		setBounds(x, y, WIDTH, HEIGHT);
		setVisible(true);
		
		// # Window Close
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		new Thread(this).start();
	}
	
	/**
	 * 아래의 run() 메소드를 통해 draw 메소드를 계속 호출! 
	 * @param canvas
	 */
	public abstract void draw(Graphics g);
	
	void clear() {
		canvas.getGraphics().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	
	@Override
	public void run() {
		while (this.isShowing()) {
			clear();
			draw(canvas.getGraphics());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
