package study.java.lambda;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * # class Optional
 *  
 *  Optional이라는 클래스는 값이 있거나 없는 경우를 표현 하기 위한 클래스로
 *  map, filter, flatMap 등의 고차 함수를 가지고 있다.
 *  이 함수들을 통해서 언제 발생할지 모르는 NullPointerException를 방지하기 위한 로직을 줄여줄 수 있다.
 *  
 *  @author JeongWon
 */
public class LambdaOptional {
	public static void main(String[] args) {
		new LambdaOptional();
	}

	/*
	 * # 학생의 출첵 여부를 알 수 있는 Predicate 함수
	 * -> LambdaPredicate 참고!
	 */
	
	/*
	 * # Consumer<T> - T를 파라미터로 받는 accept(T t) 하나의 메소드를 갖는 함수형 인터페이스
	 * 간단한 Message 프린트를 위한 Consumer 인터페이스
	 */
	Consumer<String> printer = message -> System.out.println(message + "님 콜!");

	public LambdaOptional() {
		// # 기존의 Null Checking 방식
		String name = "지용";
		if( name != null ) {
			printer.accept(name);
		}
		
		// # Optional 을 이용한 Null Checking
		// 1) 비어있는 Optional 
		Optional<String> optEmpty = Optional.empty();
		optEmpty.ifPresent(printer);
		
		// 2) Null 허용하지 않는 객체 생성 - Null을 입력시 변수 선언에서 바로 Exception
		Optional<String> optNoNull = Optional.of("개리");
		printer.accept(optNoNull.get());
		
		// 3) Null도 수용하는 Opt
		Optional<String> optCanNull = Optional.ofNullable(null);
		Optional<String> optCanNull2 = Optional.ofNullable("몽몽");
		optCanNull.ifPresent(printer);
		optCanNull2.ifPresent(printer);
		
		// 4) Null인 경우 Default값 정의
		Optional<String> optCanNull3 = Optional.ofNullable("길음");
		printer.accept(optCanNull3.orElse("수지"));
		
		// # 위에 설명한 filter, map 등의 고차원 함수 활용 예제
		Optional<String> optPractice = Optional.ofNullable("재용");
		optPractice.filter(p -> p.contains("강")).ifPresent(printer);
		
		optPractice.map(p -> p.contains("강") ? p : "기본값").ifPresent(printer);
	}

}
