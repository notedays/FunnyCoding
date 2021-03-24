package study.java.basic;

/**
 * # 변수란? 특정한 데이터를 담을 수 있는 주머니
 * - 이름 규칙 : 소문자로 시작!
 *
 * # 변수는 왜 사용하는가??
 *	변수란 말 그대로 변할 수 있는 수 (value)로 프로그램 실행 중에 데이터가 어떻게 변할지 개발자가 알 수 없는 상황에서
 * 	데이터의 변동과 상관없이 프로그램을 작성할 수 있도록 해주는 요소이다.
 * 	(예: int age = 13; 이때 age가 초기값은 13이지만 다른 입력 등으로 인해 17이 될지 62가 될지 개발자는 알 수 없음)
 *
 * 	또한, 여러 실행 문장에서 같은 값으로 적용되어져야 하는 경우 변수를 통해 한번에 제어가 가능하므로 단순 복&붙 과 같은 반복작업을 없애줄 수 있다.
 *
 * # 변수 생성
 * - 변수의 생성은 변수 선언 & 변수 초기화 두가지 단계로 나뉜다. 
 * 
 * 		i) 변수 선언 
 * 			-  자료형 변수명;
 * 			ex) int num;
 * 
 * 		i) 변수 초기화 
			-  변수 초기화만 따로 하는 경우 메소드 범위 내에서만 가능!
			-  변수명 = 데이터;
 * 			ex) num = 3;
 * 
 * 		i) 변수 선언과 초기화를 동시에 하는 것도 가능     
 *			String name = "홍길동";
 * 
 * 
 * # 변수의 기본자료형
 * 	1) 숫자 
 * 		- 정수 : byte, short, int, long	
 * 			- 보통 int를 가장 많이 사용! long을 사용 시 숫자 끝에 'l' 붙여줌 	
 * 			ex) 0, 10, 20, 1502049l 
 * 		
 * 		- 실수 : float, double
 * 			- float : 끝에 'f' / double : 끝에 'd' 
 * 			ex) 1.5f, 2.7d
 * 
 * 	2) 문자 
 * 		- 문자 하나 : char  'a'
 * 		- 문자열 : String  "딩동댕" 
 * 
 * 	3) 논리 
 * 		- 논리의 경우 if문 또는 while문에 자주 사용됨!
 * 		true (참)
 * 		false (거짓)
 * 
 * 
 * # 변수의 종류
 * 	i) 전역 변수 
 * 		- 클래스 범위에 생성되는 변수로 클래스 내의 모든 범위에서 사용 가능!
 * 
 * 	i) 지역 변수 
 * 		- 메소드 내에서 생성되어 사용되는 변수로 해당 메소드 내에서만 사용 가능! (파라미터도 지역 변수!)
 * 
 * 	* 전역 변수와 지역 변수가 이름이 같은 경우 지역변수가 선언된 메소드 내에서는 지역변수가 사용된다!
 * 	* 이 때, 전역변수를 사용하려면 this.변수명 을 사용해야함! ( ex : this.sentence )
 * 	* 참고) 여기서 this. 는 해당 클래스 . 을 의미하며 클래스 범위 안을 찾아본다는 의미! 
 * 
 *
 */
public class VariableStudy {
	
	// @ 전역변수 
	String sentence = "Anyone can be anything!";
	
	public VariableStudy() {
		// @ 지역변수
		String sentence = "Try everything!";
		
		System.out.println(sentence); // @ 이 경우 sentence는 이 문장과 더 가까운 바로 위의 sentence = "Try everything!" 를 참조!
		
		System.out.println(this.sentence); // @ this.을 붙인 경우 클래스 범위에 정의된 sentence = "Anyone can be anything!" 을 참조!
	}
	
	public void print(String sentence) {
		System.out.println(sentence); // @ 파라미터도 지역변수로 이 경우의 sentence는 파라미터로 받은 String 값을 출력!
		
		System.out.println(this.sentence); // @ this.이 붙었으므로 클래스 범위에 정의된 전역변수 출력!
	}
	
	public static void main(String[] args) {
		new VariableStudy();
	}
}
