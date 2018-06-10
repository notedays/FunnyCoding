package practice.sohee;

import util.ConsoleUtil;

/*
 * *~ 동물 정보 ~*
 * 종류 : 
 * 이름 : 
 * 나이 : 
 * 성별 : 
 * 중성화 여부 :
 * 
 */
public class AnimalChart {

	ConsoleUtil console = ConsoleUtil.getInstance();

	public static void main(String[] args) {
		new AnimalChart();
	}

	public AnimalChart() {
		while (true) {
			String kind = console.inputText("종류를 입력하세요.");
			String name = console.inputText("이름을 입력하세요.");
			int age = console.inputNo("나이를 입력하세요.");
			String gender = console.inputText("성별을 입력하세요.");
			boolean unisex = console.inputYN("중성화 여부를 입력하세요(Y/N).");

			System.out.println("*~ 동물정보 ~*");
			System.out.println("종류 : " + kind);
			System.out.println("이름 : " + name);
			System.out.println("나이 : " + age);
			System.out.println("성별 : " + gender);
			System.out.println("중성화 여부 : " + unisex);
		}
	}
}
