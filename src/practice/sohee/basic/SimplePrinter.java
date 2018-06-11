package practice.sohee.basic;

import util.ConsoleUtil;

public class SimplePrinter {

	public static void main(String[] args) {
		new SimplePrinter();
	}

	ConsoleUtil console = ConsoleUtil.getInstance();

	public SimplePrinter() {
		System.out.println(console.inputText("이름") + "님 어서오세요~!!!!");
	}
}
