package study.java.lambda;

import java.util.function.IntBinaryOperator;

/**
 * # LambdaBasic2
 * LambdaBasic2 에서는 앞선 Method Reference에 대해서 알아보고 
 * 이것을 람다식과 병행하여 어떻게 활용이 가능할 지 알아보자!
 * 
 * # Method Reference
 * 메소드 참조는 말 그대로 메소드를 참조해서 매개 변수(파라미터)의 정보 및 리턴 타입을 알아내어 
 * 람다식에서 불필요한 매개 변수를 제거하는 것이 목적
 * 
 * - 사용법
 * 정적 메소드 : Class명::메소드명    ex) Math::max 
 * 인스턴스 메소드 : 참조 변수명::메소드명 ex) System.out::println
 * 
 * @author JeongWon
 *
 */
public class LambdaBasic2 {
	public static void main(String[] args) {
		new LambdaBasic3();
	}

	// # 테스트를 위한 함수형 인터페이스 작성
	@FunctionalInterface
	interface MyCaller<T>{
		void call(T t);
	}
	
	// # Method Reference 적용하여 활용하기!
	MyCaller<String> caller = System.out::print;
	
	public LambdaBasic2() {
		/*
		 *  # 파라미터를 받아서 결과값을 리턴하는 기본 람다식 표현
		 *  - IntBinaryOperator는 Java API가 기본 제공하는 함수형 인터페이스
		 */
		IntBinaryOperator operator = (left, right) -> Math.max(left, right);
		caller.call(""+operator.applyAsInt(3, 13));
		
		/*
		 * 위에서 보면 람다식은 단순히 left, right 두 매개변수를 Math.max 라는 메소드에 전달하는 역할만 하고 있다.
		 * 때문에 이것을 Method Reference를 사용하면 보다 간결하게 코드를 작성할 수 있다.
		 * 
		 * - 이 때, 해당 메소드의 매개변수와 리턴 값 등이 함수형 인터페이스에 정의된 것과 일치해야한다.
		 */
		IntBinaryOperator operator2 = Math::max;
		caller.call(""+operator2.applyAsInt(5, 15));
		
		
	}
}
