package study.java.thread;

/**
 *	# 스레드를 이해하기 이전에 락(lock) 또는 모니터(monitor)를 이해해야 한다!
 */
public class MonitorStudy {
	
	private int count;
	Object lock = new Object();
	
	/*
	 * # 여러 스레드가 동시에 접근할 때 동기화가 보장되지 않는 메소드!
	 * - count++ 의 경우 count = count + 1; 로  3단계로 나뉜다.
	 *   1) 현재 count 값 읽기
	 *   2) count + 1
	 *   3) count 에 새로운 값 쓰기
	 * 
	 * - 이 과정에서 만약 다른 스레드가 접근한다면, 동기화가 보장되지 않고 원치않는 결과가 나올 수 있다.
	 * ex) 2단계에서 다른 스레드가 먼저 작업을 해버린 경우, 
	 * 	1) 1단계에서 읽은 값이 1이었을때 이미 다른 스레드가 연산을 하여 2가 되었고 
	 * 	2) 2 + 1 을 하게 되어 결과적으로 3이라는 결과를 가지게 된다.
	 * 	3) 이는 최초에 예상했던 1 + 1 의 결과인 2와는 다른 값을 리턴하게 되므로 오류라고 볼 수 있다.
	 */
	public int increaseWithoutLock() {
		return ++count;
	}
	
	/*
	 *	# 위의 메소드에서 synchronized ( lock ) 을 이용하여 
	 *	lock Object의 락을 획득하였다. 때문에 다른 스레드에서 해당 메소드에 접근하기 위해선
	 *	lock이 해제될때까지 기다려야만 한다.
	 */
	public int increaseWithLock() {
		synchronized (lock) {
			return ++count;
		}
	}
	
	/*
	 * # 위의 경우 synchronized 블럭이 메소드 전체 기능을 감싸는 경우 아래와 같이 메소드 자체에 synchronized 걸수 있다!
	 * - 단 이때의 synchronized의 락은 lock Object가 아닌 this Class 임을 명심하자!
	 */
	public synchronized int increaseWithMethodLock() {
		return ++count;
	}
	
	
	public static void main(String[] args) {
		new MonitorStudy();
	}
}
