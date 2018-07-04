package examples.thread;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.ConsoleUtil;

/**
 * # 스레드를 이해하기 위한 간단한 예제
 * - 클래스 선행학습 필요! (내부 클래스 사용)
 */
public class ThreadExample {
	public static void main(String[] args) {
		new ThreadExample();
	}

	Thread coolTimeThread;
	ConsoleUtil console = ConsoleUtil.getInstance();

	List<Cook> cookList = new ArrayList<>();
	List<Cook> coolTimeList = new ArrayList<>();

	public ThreadExample() {
		// @ 요리 기술 리스트 준비
		prepareCookList();

		// @ 쿨타임 관리 스레드 실행
		coolTimeThread = new Thread(() -> {
			synchronized (coolTimeList) {
				while (true) {
					try {
						if (!coolTimeList.isEmpty()) {
							Iterator<Cook> iter = coolTimeList.iterator();
							while (iter.hasNext()) {
								Cook cook = iter.next();
								if (cook.coolRest-- > 0) {
									System.out.println(cook.name + " 중입니다..! : " + cook.coolRest);
								} else {
									cook.coolRest = 0;
									iter.remove();
								}
							}
							Thread.sleep(1000);
						} else {
							Thread.sleep(50);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		coolTimeThread.start();

		// @ 실제 사용자의 인풋 관리
		while (true) {
			int no = 0;
			// @ 요리 기술 목록 보여주기
			for (Cook cook : cookList) {
				System.out.println(++no + ". " + cook.name + " (" + cook.coolTime + " 초)");
			}

			Cook cook;
			do { // @ 번호 입력 받기 : 이때 쿨타임 리스트에 요리가 이미 있다면 다른 요리 입력받도록 유도!
				cook = cookList.get(console.inputNo("요리할 번호를 입력하세요", 1, cookList.size()) - 1);
			} while (coolTimeList.contains(cook));
			
			cook.coolRest = cook.coolTime;
			coolTimeList.add(cook);
		}
	}

	// # 스킬 정보를 담는 스킬 클래스 - enum으로 하면 더 편하게 관리 가능하지만 간단한 클래스 활용예제를 보여주기 위해!
	class Cook {
		String name;
		int coolTime;
		int coolRest;

		public Cook(String name, int coolTime) {
			super();
			this.name = name;
			this.coolTime = coolTime;
			this.coolRest = coolTime;
		}

		public Cook(Object[] cook) {
			this((String) cook[0], (Integer) cook[1]);
		}
	}

	public void prepareCookList() {
		cookList.add(new Cook("밀가루 반죽하기", 10));
		cookList.add(new Cook("굽기", 15));
		cookList.add(new Cook("크림바르기", 7));
	}
}
