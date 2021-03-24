package study.java.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicFill extends GraphicBasic {

	final int gap = 5;
	Color[] colors = { Color.CYAN, Color.PINK, Color.GRAY, Color.MAGENTA };

	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < colors.length; i++) {
			int x = (int) (System.currentTimeMillis() / 3 % getWidth());
			int y =  i * this.getHeight() / colors.length + gap;
			
			g.setColor(colors[i]);
			g.fillRect(x, y, 80, 80);
		}
	}

	public static void main(String[] args) {
		new GraphicFill().setBackground(Color.WHITE);
	}
}
