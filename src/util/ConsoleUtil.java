package util;

import java.util.List;
import java.util.Scanner;

public class ConsoleUtil {

	// # SingleTone
	private static ConsoleUtil console = new ConsoleUtil();

	private ConsoleUtil() {}

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
			} catch (Exception e) {}
		} while (input == null);
		return input;
	}

	/**
	 * # 콘솔창에서 범위안의 숫자를 입력 받을 수 있는 메소드<br>
	 * - 입력 범위 : start <= 입력 받은 숫자 <= end
	 * @param showText : 입력받기 전 보여줄 안내 문구 
	 * @return
	 */
	public int inputNo(String showText, int start, int end) {
		int input = -1;
		do {
			input = inputNo(showText);
		} while (input == -1 || input < start || input > end);
		return input;
	}

	/**
	 * # 콘솔창에서 숫자를 입력 받을 수 있는 메소드<br>
	 * - 문자 등 잘못된 형식의 입력 시 다시 입력하도록 유도!
	 * @param showText
	 * @return
	 */
	public int inputNo(String showText) {
		do {
			try {
				System.out.print(showText + " : ");
				int no = scan.nextInt();
				return no;
			} catch (Exception e) {} finally {
				scan.nextLine();
			}
		} while (true);
	}

	public boolean inputYN(String showText) {
		String text = null;
		do {
			text = inputText(showText + " [y/n]").toLowerCase();
		} while (!text.equals("y") && !text.equals("n"));
		return text.equals("y");
	}

	public void printNumberedList(List<Object> list) {
		int index = 0;
		for (Object e : list) {
			System.out.printf("%d. %s\n", ++index, e);
		}
	}

}
