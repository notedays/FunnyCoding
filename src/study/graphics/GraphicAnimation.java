package study.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class GraphicAnimation extends GraphicBasic {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new GraphicAnimation();
	}

	private final int CHAR_WIDTH = 100;
	private final int CHAR_HEIGHT = 150;
	private final int UP = 0;
	private final int RIGHT = 1;
	private final int DOWN = 2;
	private final int LEFT = 3;
	private final int MOVE_SPEED = 20;

	// # 캐릭터 이미지
	Image img = new ImageIcon("src/study/graphics/rpg.png").getImage();

	// # 캐릭터의 상태값
	boolean isMoving, isLeft, isRight, isDown, isUp, isSpin;
	int x, y, direction;

	public GraphicAnimation() {
		// @ 기본 방향 아래 & 캐릭터 위치 가운데
		direction = DOWN;
		x = getWidth() / 2 - CHAR_WIDTH / 2;
		y = getHeight() / 2 - CHAR_HEIGHT / 2;

		// @ 배경 색 - 초록색
		setBackground(new Color(47, 153, 29));

		// @ 키 리스너 적용
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// @ Idle 상태의 캐릭터 애니메이션
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					isUp = false;
					break;
				case KeyEvent.VK_RIGHT:
					isRight = false;
					break;
				case KeyEvent.VK_DOWN:
					isDown = false;
					break;
				case KeyEvent.VK_LEFT:
					isLeft = false;
					break;
				case KeyEvent.VK_SPACE:
					isSpin = false;
					break;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// @ 특정 키입력에 따른 애니메이션 상태 변화 
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					direction = UP;
					isUp = true;
					break;
				case KeyEvent.VK_RIGHT:
					direction = RIGHT;
					isRight = true;
					break;
				case KeyEvent.VK_DOWN:
					direction = DOWN;
					isDown = true;
					break;
				case KeyEvent.VK_LEFT:
					direction = LEFT;
					isLeft = true;
					break;
				case KeyEvent.VK_SPACE:
					isSpin = true;
					break;
				}
			}
		});
	}

	@Override
	public void draw(Graphics g) {
		long curTime = System.currentTimeMillis();

		// @ 텍스트 표시
		drawText(g);

		// @ 캐릭터 이동 처리
		moveCharacter();

		// @ 이미지 그리기
		drawCharacter(curTime, g);
	}

	public void drawText(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Default", Font.BOLD, 20));
		g.drawString("# 이동 : 방향키", 10, 50);
		g.drawString("# 회전 : 스페이스", 10, 80);
	}

	public void drawCharacter(long curTime, Graphics g) {
		// @ 캐릭터가 보는 방향에 따른 이미지 자르기
		int timeRest = (int) (curTime / 70 % 3);
		g.setClip(x, y, CHAR_WIDTH, CHAR_HEIGHT);

		if (!isMoving) {
			timeRest = 0;
		}

		if (isSpin) {
			direction = direction < LEFT ? direction + 1 : UP;
		}

		// @ 이미지 그리기
		int charX = x - (timeRest * CHAR_WIDTH);
		int charY = y - (direction * CHAR_HEIGHT);
		g.drawImage(img, charX, charY, this);
	}

	public void moveCharacter() {
		isMoving = isLeft || isDown || isRight || isUp;
		if (isMoving) { // @ 이동 중인 경우 이동 처리
			if (isLeft) {
				x = Math.max(x - MOVE_SPEED, 0);
			}
			if (isRight) {
				x = Math.min(x + MOVE_SPEED, this.getWidth() - CHAR_WIDTH);
			}
			if (isDown) {
				y = Math.min(y + MOVE_SPEED, this.getHeight() - CHAR_HEIGHT);
			}
			if (isUp) {
				y = Math.max(y - MOVE_SPEED, 0);
			}
		}
	}
}
