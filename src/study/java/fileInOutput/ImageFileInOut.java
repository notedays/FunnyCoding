package study.java.fileInOutput;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageFileInOut {
	public static void main(String[] args) {
		new ImageFileInOut();
	}
	
	public ImageFileInOut() {
		// # 파일 복사하기 : 파일의 byte를 담은 배열로 변환
		File imageFile = new File("suzy_move.gif");
		byte[] fileArray = copy(imageFile);
		
		// # 파일 붙여넣기 : 새로 만들 파일을 형성하고 해당 파일에 위에서 복사한 바이트 배열을 출력
		File pasteFile = new File("imageFileCopy.gif");
		paste(fileArray, pasteFile);
	}
	
	// # 파일 복사하기
	private byte[] copy(File file){
		byte[] bytes = new byte[0];
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
			bytes = new byte[in.available()];
			in.read(bytes);
			System.out.println(file.getAbsolutePath()+" 파일을 복사하였습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes;
	}
	
	// # 파일 붙여넣기
	private void paste(byte[] bytes, File file){
		try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))){
			out.write(bytes);
			System.out.println(file.getAbsolutePath()+" 파일을 생성하였습니다.");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
