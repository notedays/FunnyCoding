package practice.sohee.basic;

import util.ConsoleUtil;

public class SimpleGugudan {
	public static void main(String[] args) {
		new SimpleGugudan();
	}

	// # 복사해서 변수 생성!
	ConsoleUtil console = ConsoleUtil.getInstance();

	public SimpleGugudan() {
		int num = console.inputNo("숫자를 입력하세요.");
		for (int i = 1; i <= 9; i++) { // i++ :: i = i + 1
			System.out.println(num + " x " + i + " = " + (num * i));
		}
	}
}
