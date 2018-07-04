package examples.thread;

public class SimpleTest extends Thread {

	Integer money = 0;

	public static void main(String[] args) throws InterruptedException {
		new SimpleTest();
	}

	public SimpleTest() throws InterruptedException {
		// @ 미리 SimpleTest 스레드를 start 한다!
		this.start();

		while (true) {
			synchronized (money) {
				// @ SimpleTest 스레드가 notify() 할때까지 대기한다.
				wait();

				System.out.println("건물을 산다!");
				money = 0;
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (money) {
				for (int i = 0; i < 10; i++) {
					System.out.println(String.format("돈을 모읍니다. %d원", money += 100));
				}
				notify();
			}
		}
	}
}
