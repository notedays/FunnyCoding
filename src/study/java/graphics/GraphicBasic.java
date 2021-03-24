package study.java.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class GraphicBasic extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	// # Toolkit - 윈도우 사이즈 구해서 위치 조정해줄 변수
	Toolkit toolkit = getToolkit();

	public Image preImage;

	public GraphicBasic() {
		Dimension d = toolkit.getScreenSize();

		// # Setting Canvas
		setBackground(Color.BLACK);

		// # Setting JFrame
		int x = (int) (d.getWidth() / 4);
		int y = (int) (d.getHeight() / 7);
		setBounds(x, y, x * 2, y * 5);
		setVisible(true);

		// # Window Close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Thread(this).start();
	}

	/**
	 * 아래의 run() 메소드를 통해 draw 메소드를 계속 호출! 
	 * @param canvas
	 */
	public abstract void draw(Graphics g);

	@Override
	public void paint(Graphics g) {
		// @ 더블 버퍼링 - 임시 이미지에 먼저 그리기
		preImage = createImage(getWidth(), getHeight());
		draw(preImage.getGraphics());

		// @ 그려진 이미지를 다시 그려줌
		g.drawImage(preImage, 0, 0, this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				Thread.sleep(50);
			} catch (Exception e) {
			}
		}
	}

}
