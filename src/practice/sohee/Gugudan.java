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
			dan = console.inputNo("����� �������� �ܼ��� �Է��ϼ���", 1, 9);
			
			for (int i = 1; i <= 9; i++) {
				System.out.println(dan + " X " + i + " = " + (dan * i));
			}
		} while ( dan != 2 );
	}
}
