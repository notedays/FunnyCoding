package study.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GraphicText extends GraphicBasic{
	
	static final String TEXT_LEFT = "Hello Graphics!!";
	static final String TEXT_RIGHT = "Drawing Text!!";
	private boolean isLeft;
	
	public void draw (Graphics g) {
		isLeft = System.currentTimeMillis() % 2000 < 1000;
		g.setColor(Color.white);
		g.setFont(new Font("Consolas", Font.ITALIC, 40));
		g.drawString(getChangingText(), canvas.getWidth() / 4, canvas.getHeight() / 2);
	}
	
	private String getChangingText() {
		return isLeft ? TEXT_LEFT : TEXT_RIGHT;
	}
	
	public static void main(String[] args) {
		new GraphicText();
	}
}
