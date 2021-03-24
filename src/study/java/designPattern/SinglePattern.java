package study.java.designPattern;

/**
 * # 싱글 패턴이란? 
 * - 프로젝트 내에서 단 하나의 객체만 생성하여 사용하고 싶고, 이를 보장해야할때 사용하는 패턴
 * - 싱글 패턴으로 작성된 객체를 가져올땐 클래스명.getInstance() 식의 static 한 접근을 해야한다!
 * 
 * i) new 클래스 () ; 를 못하도록 제어!
 * i) 오로지 생성된 객체를 가져다 쓸 수 있도록..
 *
 */
public class SinglePattern {
	
	// 1) 생성자를 호출 할 수 없도록 private으로 제한
	private SinglePattern() {
	}
	
	// 2) 다른 곳에서 참조할 객체를 미리 생성! 
	// - 이때 static은 해당 클래스의 객체 생성(생성자 호출)을 할 수 없으므로 static한 방법으로 가져오기 위하여!
	private static SinglePattern pattern = new SinglePattern();
	
	// 3) 미리 생성한 객체 가져올 메소드 
	// - 외부에서 가져올 수 있어야 하므로 public & static!
	public static SinglePattern getInstance() {
		return pattern;
	}
	
}
