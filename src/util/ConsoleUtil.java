package util;

import java.util.Scanner;

public class ConsoleUtil {

	// # SingleTone
	private static ConsoleUtil console = new ConsoleUtil();

	private ConsoleUtil() {
	}

	public static ConsoleUtil getInstance() {
		return console;
	}

	// # Variable
	private Scanner scan = new Scanner(System.in);

	/**
	 * # 콘솔창에서 문자를 입력 받을 수 있는 메소드
	 * @param showText : 입력받기 전 보여줄 안내 문구 
	 * @return
	 */
	public String inputText(String showText) {
		String input = null;
		do {
			try {
				System.out.print(showText + " : ");
				input = scan.nextLine();
			} catch (Exception e) {
			}
		} while (input == null);
		return input;
	}

	/**
	 *  # 콘솔창에서 숫자를 입력 받을 수 있는 메소드<br>
	 *  - 입력 범위 : start <= 입력 받은 숫자 < end
	 * @param showText : 입력받기 전 보여줄 안내 문구 
	 * @return
	 */
	public int inputNo(String showText, int start, int end) {
		int input = -1;
		do {
			try {
				System.out.print(showText + " : ");
				input = scan.nextInt();
			} catch (Exception e) {
			} 
			scan.nextLine();
		} while (input == -1 || input < start || input >= end);
		return input;
	}

	public boolean inputYN(String showText) {
		String text = null;
		do {
			text = inputText(showText + " [y/n]").toLowerCase();
		} while (!text.equals("y") && !text.equals("n"));
		return text.equals("y");
	}

}
