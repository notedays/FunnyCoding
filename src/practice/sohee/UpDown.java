package practice.sohee;

import util.ConsoleUtil;

public class UpDown {
	ConsoleUtil console = ConsoleUtil.getInstance();

	public static void main(String[] args) {
		new UpDown();
	}

	public UpDown() {
		while (true) {
			int firstNum = console.inputNo("첫번째 숫자를 입력하세요.");
			int secondNum = console.inputNo("두번째 숫자를 입력하세요.");
			boolean isBigger = firstNum > secondNum;
			boolean isSmaller = firstNum < secondNum;
			if (isBigger) {
				System.out.println("첫번째 숫자가 더 큽니다.");
			} else if (isSmaller) {
				System.out.println("두번째 숫자가 더 큽니다.");
			} else {
				System.out.println("두 숫자의 값이 같습니다.");
			}
		}

	}
}
