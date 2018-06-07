package examples;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import study.graphics.GraphicBasic;

public class MovingSquare extends GraphicBasic implements KeyListener {

	public static void main(String[] args) {
		new MovingSquare().canvas.setBackground(Color.white);
	}

	List<MyRect> squareList = new ArrayList<>();

	// # 색깔
	private static final Color[][] COLORS = { { Color.blue, Color.green, Color.orange },
			{ Color.pink, Color.black, Color.gray }, { Color.yellow, Color.magenta, Color.cyan } };

	private static final int SPEED = 210;

	MyRect myRect;
	Point defaultPoint;

	public MovingSquare() {
		this.canvas.addKeyListener(this);

		int size = 70;

		int xCount = 3;
		int yCount = 3;

		// # Rect 정의
		for (int y = 0; y < yCount; y++) {
			for (int x = 0; x < xCount; x++) {
				MyRect rect = new MyRect(COLORS[x][y]);
				rect.setBounds(y * size * 3 + size * 2, x * size * 3 + size, size, size);
				squareList.add(rect);
			}
		}

		// # 정 중앙의 스퀘어를 컨트롤!
		myRect = squareList.get(4);
		defaultPoint = (Point) myRect.getLocation().clone();
	}

	@Override
	public void draw(Graphics g) {
		for (MyRect rect : squareList) {
			g.setColor(rect.color);

			if (!rect.equals(myRect)) {
				g.fillRoundRect(rect.x, rect.y, rect.width, rect.height, rect.width / 3, rect.height / 3);
			}
		}
		g.setColor(myRect.color);
		g.fillOval(myRect.x, myRect.y, myRect.width, myRect.height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if (myRect.x > 140)
				myRect.x -= SPEED;
			break;
		case KeyEvent.VK_RIGHT:
			if (myRect.x < 560)
				myRect.x += SPEED;
			break;
		case KeyEvent.VK_UP:
			if (myRect.y > 70)
				myRect.y -= SPEED;
			break;
		case KeyEvent.VK_DOWN:
			if (myRect.y < 490)
				myRect.y += SPEED;
			break;
		}
		for(MyRect rect : squareList) {
			System.out.println(rect.color);
			if(rect.getLocation().equals(myRect.getLocation())) {
				this.canvas.setBackground(rect.color);
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(defaultPoint != null) {
			myRect.setLocation(defaultPoint);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	// # 사각형 정보를 담는 클래스
	class MyRect extends Rectangle {
		final Color color;

		MyRect(Color color) {
			this.color = color;
		}
	}
}
