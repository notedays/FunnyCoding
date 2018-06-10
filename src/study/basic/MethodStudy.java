package study.basic;

/**
 * # 메소드란? 실행할 여러 문장들의 묶음. 
 * - 메소드의 이름 형태 : 소문자 ()    ex) showIntroduce()
 * 
 * - 메소드 생성 
 * 		접근제한자 리턴자료형 이름 ( 파라미터 ) { } 
 * 	
 * 	ex) public int getPrice( String bread ){
 * 			switch(bread){ 
 * 			case "소보루" : 
 * 				return 1500; 
 * 			case "크림빵" : 
 * 				return 1300; 
 * 			case "피자빵" : 
 * 				return 1900; 
 * 			default : 
 * 				return 1000; 
 * 			} 
 * 		}
 *
 * --> 이때 리턴자료형 & 파라미터는 없을 수도 있음! ( 리턴자료형 x : void / 파라미터 x : 빈소괄호() )
 *
 *
 * - 메소드를 왜? 사용할까?? 
 * -> 	같은 작업들을 여러 곳에서 자주 사용하게 될 경우 메소드로 따로 작업해두면 해당 메소드만 콜하면 되지만, 
 * 		그렇지 않은 경우 같은 코드를 여러군데에서 복사 & 붙여넣기 하게 된다! 
 * 
 * 		이때 해당 작업에 수정사항이 생겼을 경우 메소드로 짜둔 경우 메소드만 수정하면 전체에 적용되지만, 
 * 		그렇지 않은 경우 복붙한 모든 코드를 수정해줘야 하므로 유지 보수에 시간과 비용이 많이 들어간다! 
 * 		때문에 메소드로 사용하는것이 훨씬 관리하기 편리하다!
 *
 * -> 효율적인 코딩과 유지보수 등에 필수이므로 반드시!! 익숙해질때까지 반복 반복!!
 */
public class MethodStudy {
	public static void main(String[] args) {
		new MethodStudy();
	}

	public MethodStudy() {

	}

	String introduce = "안녕하세요. Method 스터디에 오신 것을 환영합니다!";

	// # 파라미터 X 리턴 X
	public void test() {
		System.out.println("test() is called!");
	}

	// # 파라미터 O 리턴 X
	public void printMessage(String message) {
		System.out.println("Message : " + message);
	}

	// # 파라미터 X 리턴 O
	public String getIntroduce() {
		return this.introduce;
	}

	// # 파라미터 O 리턴 O
	public String getGrade(int point) {
		if (point >= 90) {
			return "A";
		} else if (point >= 80) {
			return "B";
		} else if (point >= 70) {
			return "C";
		} else if (point >= 60) {
			return "D";
		}
		return "F";
	}
}
