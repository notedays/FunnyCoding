package study.lambda;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * # Java8 Stream
 * i) 람다 활용 기술 중 하나
 * i) 배열 또는 컬렉션 인스턴스를 다룰 때 기존의 for문 / foreach문 대용으로 사용 가능
 * 
 * i) 스트림의 3단계
 * 		1. 생성하기	: 스트림 인스턴스 생성
 * 		2. 가공하기	: 필터링 및 맵핑 등 원하는 결과를 만들기 위한 중간 과정
 * 		3. 결과 만들기	: 최종적으로 결과를 만드는 작업
 */
public class StreamBasic {

	public static void main(String[] args) {
		new StreamBasic();
	}

	public StreamBasic() {

	}

	public void make() {
		{ // X -> Stream : 아무것도 없는 상태에서 스트림 만들기
			Stream<Integer> emptryStream = Stream.empty(); // 빈 스트림
			Stream<Integer> generatedStream = Stream.generate(() -> 0); // generate 메소드 활용
			Stream<Integer> builderStream = Stream.<Integer>builder().add(1).add(3).build(); // Builder 활용
			Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5); // [30, 32, 34, 36, 38]
		}

		{ // 배열 -> Stream
			String[] arr = new String[] { "a", "b", "c" };
			Stream<String> stream = Arrays.stream(arr);
			Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3); // 1~2 요소 [b, c]
		}

		{ // 컬렉션 -> Stream : 인터페이스에 추가된 stream() 메소드를 이용하여 생성 가능
			Stream<Integer> stream = Arrays.asList(1, 2, 3).stream();
			Stream<Integer> parallelStream = Arrays.asList(1, 2, 3).parallelStream(); // 병렬 스트림
		}

		{ // 스트림 연결하기
			Stream<Integer> stream1 = IntStream.range(1, 5).boxed(); // [1,2,3,4]
			Stream<Integer> stream2 = IntStream.iterate(10, n -> n++).limit(3).boxed(); // [10,11,12]
			Stream<Integer> concatStream = Stream.concat(stream1, stream2);
		}
	}
}
