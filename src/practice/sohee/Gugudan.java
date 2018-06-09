package practice.sohee;

import util.ConsoleUtil;

public class Gugudan {
	public static void main(String[] args) {
		new Gugudan();
	}
	
	// # ConsoleUtil
	ConsoleUtil console = ConsoleUtil.getInstance();
	
	public Gugudan() {
		int dan = 0;
		do {
			dan = console.inputNo("출력할 구구단의 단수를 입력하세요", 1, 9);
			
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " X " + i + " = " + (dan * i));
			}
		} while ( dan != 2 );
	}
}
