package study.graphics;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicFill extends GraphicBasic {

	Color[] colors = { Color.CYAN, Color.PINK, Color.GRAY, Color.MAGENTA };

	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < colors.length; i++) {
			int x = (int) (System.currentTimeMillis() / 3 % canvas.getWidth());
			int y =  (i + 1) * 100 + 50;
			
			g.setColor(colors[i]);
			g.fillRect(x, y, 80, 80);
		}
	}

	public static void main(String[] args) {
		new GraphicFill().canvas.setBackground(Color.WHITE);
	}
}
