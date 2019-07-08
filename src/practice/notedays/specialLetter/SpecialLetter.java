package practice.notedays.specialLetter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import practice.notedays.simple.DefaultFrame;
import util.FileUtil;
import util.Music;
import util.TextUtil;

public class SpecialLetter extends DefaultFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new SpecialLetter();
	}

	// # 설정 변수값
	private static final int WIDTH = 800;
	private static final int HEIGHT = 1200;

	private final int TIME_SPEED = 50;
	private int textStartY = HEIGHT;
	private long startTime;

	// # 멤버변수
	private List<String> texts;
	private Properties properties;
	private Music bgm;
	private Font font;
	private Color fontColor;

	public SpecialLetter() {
		super(WIDTH, HEIGHT);
		setTitle("편지");
		setLayout(new FlowLayout());

		// @ 현재 클래스의 경로
		String classPath = this.getClass().getResource("").getPath();

		// @ Config.yml 로딩
		properties = loadConfig(classPath);

		// @ 편지지 텍스트 로딩
		loadText(classPath + properties.getProperty("letter_text"));

		// @ 폰트 로딩
		loadFont(properties);

		// @ 배경 음악 로딩
		loadBGM(properties.getProperty("bg_music"));
	}

	// # config.yml 로딩
	public Properties loadConfig(String classPath) {
		Properties properties = new Properties();
		for (String text : FileUtil.loadTextFile(classPath + "/config.yml")) {
			String[] props = TextUtil.splitNoSpace(text, ":");
			if (props.length > 1) {
				properties.setProperty(props[0], props[1]);
			}
		}
		return properties;
	}

	// # 편지지 .letter 파일 로드
	public void loadText(String filePath) {
		texts = FileUtil.loadTextFile(filePath);
		for (String text : texts) {
			JLabel label = new JLabel(text);
			label.setVisible(false);
			add(label);
		}
	}

	// # 배경음악 로드
	public void loadBGM(String filePath) {
		this.bgm = new Music(new File(filePath), true);
		this.bgm.start();
	}

	// # 폰트 로드
	public void loadFont(Properties properties) {
		int[] fontColorArray = TextUtil.splitToInteger(properties.getProperty("font_color"), ",");
		this.fontColor = new Color(fontColorArray[0], fontColorArray[1], fontColorArray[2]);

		String[] fontSetting = TextUtil.splitNoSpace(properties.getProperty("font"), ",");
		this.font = new Font(fontSetting[0], Integer.parseInt(fontSetting[1]), Integer.parseInt(fontSetting[2]));
	}

	@Override
	public void draw(Graphics g) {
		if (this.properties == null) {
			return;
		}
		// @ 편지지 이미지 로딩 
		ImageIcon bgImage = new ImageIcon(properties.getProperty("bg_image"));
		g.drawImage(bgImage.getImage(), 0, 0, WIDTH, HEIGHT, this);

		if (startTime > 0l) {
			textStartY = (int) Math.max(-20000, (HEIGHT - (System.currentTimeMillis() - startTime) / TIME_SPEED));
		} else {
			startTime = System.currentTimeMillis();
		}

		// @ 폰트 색상 설정
		g.setColor(fontColor);

		// @ 글씨 로딩
		for (int i = 0; i < texts.size(); i++) {
			String text = texts.get(i);
			int textWidth = g.getFontMetrics(font).stringWidth(text);
			int positionX = (WIDTH - textWidth) / 2;
			g.setFont(font);
			g.drawString(texts.get(i), positionX, font.getSize() * i + textStartY);
		}
	}
}
