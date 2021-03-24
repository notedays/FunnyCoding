package study.java.thread;

/**
 * 
 */
public class ThreadBasic1 extends Thread {
	public static void main(String[] args) {
		new ThreadBasic1();
	}
	
	public ThreadBasic1() {
		// @ 기존의 main 스레드가 따로 돌고
		
		// @ 상속받은 Thread로 인해 ThreadBasic1 클래스 또한 스레드가 되어 따로 동작
		start();
	}

	int count;

	@Override
	public void run() {
		try {
			join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			if(count < 10) {
				System.out.println("일한 횟수 : " + ++count);
			}
		}
	}
}
