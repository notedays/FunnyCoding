package practice.sohee;

import util.ConsoleUtil;

public class DrawStar {
	ConsoleUtil console = ConsoleUtil.getInstance();

	public static void main(String[] args) {
		new DrawStar();

	}

	public DrawStar() {
		int num;
		do {
			num = console.inputNo("숫자를 입력하세요.");
			for (int i = 0; i < num; i++) {
				System.out.print("★");
			}
			System.out.println("\n");
		} while (num != 9);

	}
}
