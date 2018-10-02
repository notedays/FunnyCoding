package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	public static List<String> loadTextFile(String filePath) {
		List<String> list = new ArrayList<>();
		File file = new File(filePath);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String text;
			while ((text = reader.readLine()) != null) {
				list.add(text);
			}
		} catch (Exception e) {
		}
		return list;
	}
}
