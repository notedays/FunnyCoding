package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread implements AutoCloseable {

	private Player player;
	private boolean isLoop;
	private File file;

	public static String DEFAULT_PATH = "src/resources/sounds/";
	private String path = DEFAULT_PATH;

	public Music(String name, boolean isLoop) {
		this(new File(DEFAULT_PATH + name), isLoop);
	}

	public Music(File file, boolean isLoop) {
		this.isLoop = isLoop;
		this.file = file;
	}

	private void initialize() {
		try {
			if (player != null) {
				player.close();
			}
			player = new Player(new BufferedInputStream(new FileInputStream(file)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * # 현재 플레이 시간을 가져오는 메소드
	 * 
	 * @return
	 */
	public int getTime() {
		return player == null ? 0 : player.getPosition();
	}

	/**
	 * # 현재 재생중인 곡 & 실행중인 스레드 종료! <br>
	 * - try with resources에 사용하기 위해 implements AutoCloseable 적용
	 */
	@Override
	public void close() {
		isLoop = false;
		if (player != null) {
			player.close();
		}
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			do {
				initialize();
				player.play();
			} while (isLoop);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}

	// # Getter / Setter
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isLoop() {
		return isLoop;
	}

	public void setLoop(boolean isLoop) {
		this.isLoop = isLoop;
	}

	public boolean isPlaying() {
		return player != null && (isLoop || player.getPosition() > 0);
	}
}
