package util;

public class TextUtil {
	
	/**
	 * # 빈 스페이스 값 제거 한 split
	 * @param text
	 * @param regex
	 * @return
	 */
	public static String[] splitNoSpace(String text, String regex) {
		String[] array = text.split(regex);
		for (int i = 0; i < array.length; i++) {
			array[i] = array[i].trim();
		}
		return array;
	}
	
	/**
	 * # 스플릿 후 인트로 파스해줌
	 * @param text
	 * @param regex
	 * @return
	 */
	public static int[] splitToInteger(String text, String regex) {
		String[] array = splitNoSpace(text, regex);
		int[] newArray = new int[array.length];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = Integer.parseInt(array[i]);
		}
		return newArray;
	}
}
