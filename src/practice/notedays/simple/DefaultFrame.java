package practice.notedays.simple;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public abstract class DefaultFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	Image preImage;
	
	public DefaultFrame(int width, int height) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - width) / 2, (screenSize.height - height) / 2, width, height);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		new Thread(this).start();
	}

	@Override
	public void paint(Graphics g) {
		// @ 더블 버퍼링 - 임시 이미지에 먼저 그리기
		preImage = createImage(getWidth(), getHeight());
		draw(preImage.getGraphics());

		// @ 그려진 이미지를 다시 그려줌
		g.drawImage(preImage, 0, 0, this);
	}

	public abstract void draw(Graphics g);
	
	@Override
	public void run() {
		while (true) {
			try {
				repaint();
				Thread.sleep(30);
			} catch (Exception e) {
			}
		}
	}
}
