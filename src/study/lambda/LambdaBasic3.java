package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * # LambdaBasic3 
 * - 여기서는 Java API 에서 기본으로 제공하는  함수형 인터페이스에 대해 알아보자.
 * 
 * 1) Consumer<T> : accept(T t) 
 * - t 라는 하나의 인자 (파라미터 : Type T) 를 받는 리턴 값 없는 메소드를 가진 함수형 인터페이스
 * 
 * 2) Function<T, R> : R apply(T t) 
 * - t 라는 하나의 인자(파라미터 : Type T)를 받아서 R을 리턴 값으로 하는 함수형 인터페이스
 * 
 * 3) Predicate<T> : boolean test(T t) 
 * - 조건 판단할 때 사용하기 좋은 함수로 하나의 인자(파라미터 : Type t)를 받아서 boolean 값을 리턴하는 함수형 인터페이스
 * - 위의 Function<T, Boolean> 이랑 같은 거라고 보면 된다.
 * 
 * @author JeongWon
 */
public class LambdaBasic3 {
	public static void main(String[] args) {
		new LambdaBasic2();
	}

	// # Test를 위한 간단한 인터페이스
	@FunctionalInterface
	interface MyCaller<P> {
		void call(P param);
	}

	public LambdaBasic3() {
		MyCaller<String> caller = System.out::println;

		// ======================================================================================================

		// # Consumer<T> 기본 식
		Consumer<Integer> consumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				caller.call("Consumer Origin : " + t);
			}
		};
		consumer.accept(13);

		// # Consumer<T> Lambda식 활용
		Consumer<Integer> consumer2 = n -> caller.call("Consumer Lambda : " + n);
		consumer2.accept(20);

		// ======================================================================================================

		// # Function<T,R> 기본 식
		List<String> beautyList = Arrays.asList("수지", "아이유", "박보영", "박수진", "김태희", "한가인", "한고은", "아라가키 유이");
		Function<String, Consumer<String>> function = new Function<String, Consumer<String>>() {
			@Override
			public Consumer<String> apply(String t) {
				if (beautyList.contains(t)) {
					return name -> caller.call("미인 " + name);
				}
				;
				return System.out::println;
			}
		};
		caller.call("Function Origin : " + function.apply("송수지"));

		// # Function<T,R> Lambda식 활용
		Function<String, Consumer<String>> function2 = t -> {
			return beautyList.contains(t) ? name -> caller.call("미인  " + name) : System.out::println;
		};
		caller.call("Function Lambda : " + function2.apply("아라가키 유이"));

		Function<String, Boolean> function3 = beautyList::contains;
		caller.call("Function Lambda (method reference) : " + function3.apply("혜리"));

		// ======================================================================================================

		// # Predicate<T> 기본식 - 파라미터로 받은 수가 짝수인지 (true) 홀수(false) 인지 판단하는 함수 작성
		Predicate<Integer> predicate = new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		};
		caller.call("Predicate Origin : "+predicate.test(10));
		
		// # Predicate<T> 람다식
		Predicate<Integer> predicate2 = t -> t % 2 == 0;
		caller.call("Predicate Lambda : "+predicate2.test(19));
	}
}
