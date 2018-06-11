package practice.sohee;


import util.ConsoleUtil;

public class Calculator {
	public static void main(String[] args) {
		new Calculator();
	}

	ConsoleUtil console = ConsoleUtil.getInstance();

	public Calculator() {
		System.out.println("*~ 간단한 계산기 ~*");
		int result;
		do {
			int num1 = console.inputNo("첫번째 수 입력");
			int num2 = console.inputNo("두번째 수 입력");
			String oper = console.inputText("연산자 입력 ( +, -, *, / )");
			result = calculateSwitch(num1, num2, oper);

			if (result == -1) {
				System.out.println("에러!!");
			} else {
				System.out.println("결과 값은 ? " + result);
				System.out.println();
			}
		}while(result != -1);
	}
	
	// # if ~ else if ~ 활용한 calculate()
	public int calculateIf(int num1, int num2, String oper) {
		if (oper.equals("+")) {
			return num1 + num2;
		} else if (oper.equals("-")) {
			return num1 - num2;
		} else if (oper.equals("*")) {
			return num1 * num2;
		} else if (oper.equals("/")) {
			return num1 / num2;
		}
		return -1;
	}
	
	// # switch ~ case 
	public int calculateSwitch(int num1, int num2, String oper) {
		switch (oper) {
		case "+":
			return num1 + num2;
		case "-":
			return num1 - num2;
		case "*":
			return num1 * num2;
		case "/":
			return num1 / num2;
		default:
			return -1;
		}
	}
	
	public void noReturn() {
		while(true) {
			boolean isRepeat = console.inputYN("계속 할래?");
			if(!isRepeat) {
				break;
			}
		}
	}
}
