package enjoy.movingSquare;

import java.awt.Color;
import java.awt.Graphics;
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

	List<MyRect> squareList;

	public MovingSquare() {
		squareList = new ArrayList<>();
		int size = 70;

		int xCount = 3;
		int yCount = 3;

		for (int i = 0; i < xCount; i++) {
			for (int j = 0; j < yCount; j++) {
				MyRect rect = new MyRect(new Color( (i+10) * (j+10)));
				rect.setBounds(i * size * 3 + size * 2 , j * size * 3 + size, size, size);
				squareList.add(rect);
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		for (MyRect rect : squareList) {
			g.fillRoundRect(rect.x, rect.y, rect.width, rect.height, rect.width / 3, rect.height / 3);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	class MyRect extends Rectangle{
		Color color;

		MyRect(Color color) {
			this.color = color;
		}
	}
}
