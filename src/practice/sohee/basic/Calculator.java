package practice.sohee.basic;

import util.ConsoleUtil;

public class Calculator {
	public static void main(String[] args) {
		new Calculator();
	}
	
	// # 복사해서 변수 생성!
	ConsoleUtil console = ConsoleUtil.getInstance();
	
	public Calculator() {
		int num1 = console.inputNo("숫자1 입력");
		int num2 = console.inputNo("숫자2 입력");
		System.out.println("더하기 결과 : " + plus(num1, num2));
	}

	public int plus(int num1, int num2) {
		return num1 + num2;
	}

	public int minus(int num1, int num2) {
		return num1 - num2;
	}

	public int multiplication(int num1, int num2) {
		return num1 * num2;
	}

	public int division(int num1, int num2) {
		return num1 / num2;
	}

}
