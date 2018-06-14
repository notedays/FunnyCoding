package examples;

import java.io.File;

import util.Music;

public class ThreadExample {
	public static void main(String[] args) {
		new ThreadExample();
	}
	
	@FunctionalInterface interface Func<P1, P2> {
		void accept(P1 p1, P2 p2);
	}
	
	Func<String, Long> slowPrinter = (message, delay) -> {
		
		Music music = null;
		for (int i = 0; i < message.length(); i++) {
			try {
				if(music == null || !music.isPlaying()) {
					music = new Music(new File(Music.DEFAULT_PATH+"/effect/typewriter2.mp3"), false);
					music.start();
				}
				System.out.print(message.charAt(i));
				Thread.sleep(delay);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		music.close();
	};
	
	public ThreadExample() {
		slowPrinter.accept("Hello! I'm Message Slow Printer!!", 300l);
	}
}
