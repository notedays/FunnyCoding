package study.basic;

import practice.sohee.basic.Calculator;

/**
 * # 클래스란? 
 * 	- 변수, 메소드를 생성할 수 있는 공간으로 하나의 설계도 같은 개념.
 * 	- 객체(인스턴스)와는 다른 개념이므로 주의! :: 클래스가 설계도라면 객체(인스턴스)는 그 클래스로 만들어낸 실제 제품을 의미!
 * 	- 클래스의 사용 방법
 * 		
 * 		자료형 (클래스) 	  변수명       		 생성자
 *  	ClassStudy classStudy = new ClassStudy();
 *  	
 *  - 위 처럼 new 생성자() 호출을 통해 클래스(설계도)로 만들어낸 객체를 생성할 수 있고 이를 객체 생성이라고 한다.
 *  - 객체 생성을 통해 객체를 만들고나면 해당 객체 안에 정의돼있던 메소드, 변수등을 사용가능!
 *    (집 설계도대로 집을 짓고 나서야 비로소 집 안의 가구 등을 이용가능한 것과 마찬가지)
 *  
 *  - 객체 생성시 생성자 (메소드의 하나) 를 호출하는 것이므로 메소드 호출과 마찬가지로 생성자 내에 기술된 문장들을 실행!
 *  
 *  ex) 메소드 탈출에서의 객체 생성!
 *  
 * 	public static void main(String agrs[]) {
 * 		ClassStudy study = new ClassStudy();
 * 		
 * 		@ 순서
 * 		-> new ClassStudy() : ClassStudy 라는 설계도를 가지고 실제 집을 하나 지음
 * 		-> ClassStudy study : 그 집에 찾아가기 위해선 해당 집의 주소가 필요하고 이때 study 라는 변수에 방금 지은 새집의 주소를 저장!
 * 							( 이때 데이터를 직접 받는 기본형 변수와는 달리 해당 객체의 주소값만 가지는 변수를 '참조변수' 라고 함! )
 * 	}
 * 	
 * 
 * 
 *	# 클래스는 왜 쓰나요?
 *	- 클래스를 여러개 생성하지 않고 단 하나의 클래스에서도 프로그램을 기술하는 것이 불가능 한 것은 아니지만
 *	그렇게 되면 기본적으로 줄 수가 엄청 길어져서 원하는 코드를 찾기도 어렵고 프로그램 작성이 끝난 후 수정사항 등이 생겼을 경우
 *	클래스 전체를 살펴봐야 하므로 굉장히 시간도 오래걸리고 피곤한 작업이 된다. 하지만 기능단위별로 클래스를 따로 만들어서 작업하면
 *	수정해야 할 클래스만 수정하면 되므로 시간절약도 되고 협업하는 다른 개발자가 해당 기능을 담당하는 부분을 찾기가 쉽다.
 *	
 *	유지보수에 유리하다는 점에서는 메소드와 비슷하지만 메소드와 클래스는 그 적용 범위가 차이가 있다. 
 *	
 *	메소드의 경우 하나의 실행단위별로 수정이 될 경우에 유리한 경우라면, 클래스의 경우 하나의 기능 단위로 수정이 필요한 경우에 유리하다 
 *  
 *  ex) 콘솔창에 메세지를 출력해주는  ConsolePrinter 라는 클래스를 만들었고 print()라는 메소드를 통해 출력한다고 가정하자!
 *  	이 때, 프린트 할때 어떤 메세지의 포맷을 변경하고 싶다고 한다면 해당 클래스에서 print() 메소드를 수정하면 된다.
 *  	
 *  	하지만 콘솔 출력이 아닌 파일 출력을 해주고 싶은 경우 FilePrinter라는 클래스를 생성하여 갈아끼우기만 하면 된다!
 *		예를 들어 장난감 로봇이 있다고 가정할때 하나로 찍어진 완제품의 경우 날개를 바꾸고 싶다고 한다면 제품 전체를 바꿔야하지만
 *		조립식 로봇인 경우 날개 부품만 바꿔끼면 되는 것과 같은 것.  
 *
 *
 */
public class ClassStudy {
	public static void main(String[] args) {
		// @ 질문1) 여기서 ClassStudy study = new ClassStudy(); 식으로 변수에 담지 않는 이유는 뭘까? 
		new ClassStudy();
	}

	// @ practice.sohee.basic 패키지에 있는 Calculator 를 객체 생성하여 사용해보자!
	Calculator calculator = new Calculator();

	public ClassStudy() {
		// @ Calculator 클래스를 활용해 계산할 두 변수
		int num1 = 13;
		int num2 = 25;

		// @ 더하기
		int plus = calculator.plus(num1, num2);
		System.out.println("더하기 : " + plus);

		// @ 빼기
		int minus = calculator.minus(num1, num2);
		System.out.println("빼기 : " + minus);
		
		/*
		 *  더하기 빼기의 경우 이해하기 쉽도록 결과값을 변수에 따로 담았지만 결과값이 한번씩만 사용되고 있으므로 
		 *  곱하기, 나누기는 직접 사용!
		 */
		
		// @ 곱하기 
		System.out.println("곱하기 : " + calculator.multiplication(num1, num2));

		// @ 나누기
		System.out.println("나누기 : " + calculator.division(num1, num2));
	}

}
