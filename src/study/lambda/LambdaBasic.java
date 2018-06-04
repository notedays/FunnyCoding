package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * # 람다식 표현 JAVA 1.8 이상 지원
 * 
 * - 함수형 프로그래밍을 받아 들이기 위해 적용된 Java식 Lambda표현 
 * - 람다식 표현의 핵심은 지울 수 있는 것은 모두 지우자는 것. (컴파일러의 추론에 의지하여 코드로 표현하는 것을 없애자!) 
 * - 때문에 간결 명료해진 코드를 작성할 수 있지만 람다식에 대해 이해도가 낮은 다른 개발자의 코드 가독성이 떨어지는 문제가 있음.
 * 
 * - LambdaBasic 에서는 람다식 표현의 기본적인 활용 법 등을 살펴보자!
 * 
 * @author JeongWon
 */
public class LambdaBasic {
	public static void main(String[] args) {
		new LambdaBasic();
	}

	// # Test를 위한 간단한 인터페이스
	@FunctionalInterface
	interface MyCaller<P> {
		void call(P param);
	}

	public LambdaBasic() {
		// # 기존 방식의 표현
		MyCaller<String> caller = new MyCaller<String>() {
			@Override
			public void call(String param) {
				System.out.println(param);
			}
		};
		caller.call("Anonymous Class Origin");

		/*
		 * # Lambda 식 표현 - 위에서 지울 수 있는 부분을 모두 지워보자! 
		 * 1) 이미 대상타입에서 MyCaller 라고 명시되어 있으니 new MyCaller 부분은 없어도 컴파일러가 추론 가능하다! 
		 * 2) 위의 1번을 제외하면 남은건 call 메소드 인데 만약 구현해야하는 메소드가 하나뿐이라면 메소드 명칭이 필요없지 않을까? 
		 * 3) 컴파일러가 인터페이스와 메소드를 인지했다면 그 파라미터도 추론 가능하다! -> 구현 시 인자를 써야하니 인자를 모두 지울 순 없지만 자료형까지 명시할 필요는 없다!
		 */
		MyCaller<String> lambdaCaller = (param) -> {
			System.out.println(param);
		};
		lambdaCaller.call("Anonymous Class Lambda");

		/*
		 * # 위에서 더 뺄 수 있는게 무엇이 있을까? 
		 * 1) 파라미터가 여러개면 몰라도 하나일땐 소괄호가 없어도 되지 않을까? 
		 * 2) 실행구문이 지금처럼 1줄일땐 중괄호가 필요없지 않을까?
		 */
		MyCaller<String> lambdaCaller2 = param -> System.out.println(param + " is Called");
		lambdaCaller2.call("Anonymous Class Lambda2");

		/*
		 * 위의 단계로 보듯이 람다식 표현으로 인해 코드가 훨씬 간단해지는 것을 알 수 있다.
		 * 그렇다면 만약 인터페이스에서 메소드의 수가 하나가 아닌 여러개가 온다면 어떻게 될까?
		 * 메소드가 여러개인 인터페이스는 람다식으로 지원하지 않는다.
		 * 
		 * 만약 해당 인터페이스를 이용하여 람다식으로 작업을 했는데 협업하는 동료가 인터페이스에 메소드를 추가하는 등으로 인해
		 * 빌드가 깨어지는 현상이 생긴다면 협업자는 멘탈이 나갈 수 있다.
		 * 때문에 그런 불상사를 막기 위해 @FunctionalInterface 라는 어노테이션이 존재한다.
		 * 
		 * --> 위의 MyCaller Interface 선언 부분 확인
		 * 
		 * @FunctionalInterface 어노테이션을 붙이면 메소드를 두개 이상으로 추가하려하면 에러 표시가 난다.
		 */
	
	}
}
