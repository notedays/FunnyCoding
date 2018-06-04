package study.fileInOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileInOut {
	public static void main(String[] args) {
		new TextFileInOut();
	}
	
	public TextFileInOut() {
		// # 파일과 연동해서 데이터를 담아줄 Bean 객체
		Bean bean = new Bean("텍스트 파일 입출력 예제");
		
		// # 파일 저장하기 (Output)
		File saveFile = new File("textFile.txt");
		save(saveFile, bean);
		
		// # 저장된 파일 불러오기 (Input)
		bean.setText(""); // @ 파일로 부터 데이터를 제대로 읽어 왔는지 확인하기 위해 Bean 의 text 값을 미리 초기화
		File loadFile = new File("textFile.txt");
		bean = load(loadFile);
		System.out.println("Text : "+bean.getText());
	}
	
	void save(File file, Bean bean){
		// # try-catch-resources 구문 ( Java 7 이상 지원 ) : 객체를 자동으로 close() 해줌.
		try ( BufferedWriter writer = new BufferedWriter(new FileWriter(file)); ){
			writer.write(bean.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	Bean load(File file){
		Bean loadBean = new Bean();
		try( BufferedReader reader = new BufferedReader(new FileReader(file))){
			loadBean.setText( reader.readLine() );
		}catch(Exception e){
			e.printStackTrace();
		}
		return loadBean;
	}
}

class Bean{
	private String text;
	
	public Bean() {}
	
	public Bean(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
