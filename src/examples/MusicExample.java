package examples;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.ConsoleUtil;
import util.Music;

public class MusicExample {
	public static void main(String[] args) {
		new MusicExample();
	}

	// # Load ConsoleUtil
	ConsoleUtil console = ConsoleUtil.getInstance();

	// # Action No
	public static final int PLAY = 1;
	public static final int STOP = 2;
	public static final int EXIT = 3;

	// # Music
	List<Music> musicList = new ArrayList<>();

	public MusicExample() {
		System.out.println("*~ Simple Console MusicPlayer ~*");
		while (true) {
			try {
				int no = 0;
				String[] actions = { "음악 재생", "음악 정지", "프로그램 종료" };
				for (String action : actions) {
					System.out.println(++no + ". " + action);
				}
				switch (console.inputNo("실행할 번호 입력", 1, no)) {
				case PLAY: // @ 음악 재생
					play();
					break;
				case STOP: // @ 음악 정지
					stop();
					break;
				case EXIT: // @ 프로그램 종료
					exit();
					break;
				}
			} catch (Exception e) {
				System.out.println("[Error] : " + e.getMessage());
			}
			System.out.println();
		}
	}

	private void play() {
		// # 음악 목록 출력해주기
		System.out.println();
		System.out.println("## 음악 목록 ##");
		int no = 0;
		File[] musicArray = new File(Music.DEFAULT_PATH+"/music/").listFiles();
		for (File file : musicArray) {
			System.out.println(++no + ". " + file.getName());
		}

		// # 재생할 음악 파일 번호 및 반복재생 여부 입력받기
		int fileNo = console.inputNo("재생할 파일번호 입력", 1, no);
		boolean isLoop = console.inputYN("반복 재생 하시겠습니까?");

		// # 음악 재생하기
		Music music = new Music("music/"+musicArray[fileNo - 1].getName(), isLoop);
		music.start();

		// # 재생중인 목록에 추가!
		musicList.add(music);
	}

	private void stop() {
		// # 목록 띄워줄 StringBuilder
		StringBuilder builder = new StringBuilder("\n## 재생중인 목록 ##");

		// # 재생 상태에 따라 제거 및 리스트에 추가 처리
		int no = 0;
		Iterator<Music> iter = musicList.iterator();
		while (iter.hasNext()) {
			Music music = iter.next();
			if (!music.isPlaying()) {
				iter.remove();
			} else {
				builder.append("\n" + ++no + ". " + music.getFile().getName());
			}
		}

		// # 재생중인 목록이 없다면 return!
		if (musicList.isEmpty()) {
			System.out.println("현재 재생중인 음악이 없습니다.");
			return;
		}

		// # 현재 재생중인 목록 출력
		System.out.println(builder.toString());

		// # 음악 정지
		int musicNo = console.inputNo("정지할 음악 번호 입력", 1, no);
		musicList.remove(musicNo - 1).close();
	}

	private void exit() {
		boolean isYes = console.inputYN("정말 종료하시겠습니까?");
		if (isYes) {
			System.out.println("프로그램을 종료합니다....");
			for (Music music : musicList) {
				music.close();
			}
			System.exit(0);
		}
	}
}
