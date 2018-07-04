package examples.thread;

public class Bakery {

	int state;

	// @ 빵굽는 스레드
	Thread bakingThread = new Thread(() -> {
		synchronized(this) {
			int time = 0;
			System.out.print("빵을 굽는 중입니다.");
			while (time++ < 2) {
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			notify();
		}
	});

	// @ 먹는 스레드
	Thread eatingThread = new Thread(() -> {
		int time = 0;
		System.out.print("빵을 먹는 중입니다.");
		while (time++ < 2) {
			System.out.print(".");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	});

	public Bakery() throws InterruptedException {
		bakingThread.start();
		synchronized (bakingThread) {
			System.out.println("빵이 구워지기를 기다립니다.");
			bakingThread.wait();
			
			eatingThread.start();
			eatingThread.join();
		}
		System.out.println("main 종료");
	}

	public static void main(String[] args) throws InterruptedException {
		new Bakery();
	}
}
