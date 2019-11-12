package study.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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
 * 
 * !) 주의 사항 
 * - Stream은 재사용 불가!! 
 */
@SuppressWarnings("unused")
public class StreamBasic {

	// @ 스트림 생성
	public void makeStream() {
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

	// @ 스트림 데이터 가공
	public void processStream() {
		{ // filter : Stream에서 조건에 부합하는 요소들만 추려내는 함수
			IntStream.range(0, 10).filter(n -> n % 2 == 0); // 0 ~ 9 사이에서 짝수만 걸러내기
			Stream.<String>builder().add("한글").add("English").build().filter(word -> word.matches("[ㄱ-힣]+")); // "한글", "English" 중에서 한글만 뽑아내기
		}

		{ // map : Stream의 데이터들을 원하는 데이터로 변환한 Stream으로 바꾸는 함수
			// Stream<String> -> Stream<Integer> 로 변환
			Arrays.asList("One", "Two", "Three", "Four").stream().map(word -> word.length());

			// mapToInt를 통해 IntStream으로 바로 변환하여 IntStream 내의 sum() 등의 함수 호출 가능
			Arrays.asList("One", "Two", "Three", "Four").stream().mapToInt(word -> word.length()).sum();

			// flat Map : Stream 내부 데이터 안의 집합 데이터를 병합한 하나의 Stream으로 변환하는 함수
			// Stream<Character> 반환 : ['O','n','e','T','w','o']
			Arrays.asList("One", "Two").stream().flatMap(word -> word.chars().boxed())
					.forEach(code -> System.out.println((char) code.intValue()));

			// 각각의 내부 리스트에 담긴 숫자를 모두 합친 하나의 스트림 생성
			List<List<Integer>> outList = new ArrayList<>();
			outList.add(Arrays.asList(1, 3, 5, 7, 9));
			outList.add(Arrays.asList(2, 4, 6, 8, 10));
			outList.stream().flatMap(innerList -> innerList.stream()).sorted(); // [1,2,3,4,5,6,7,8,9,10]
		}

		{ // distinct : 중복된 데이터 제거
			Arrays.asList("One", "Two", "Three", "Four").stream().distinct();
		}

		{ // sorted : 정렬
			Arrays.asList("One", "Two", "Three", "Four").stream().sorted();
			Arrays.asList("One", "Two", "Three", "Four").stream().sorted((word1, word2) -> word1.length() - word2.length());
		}

		{ // 모두 섞어 써보기
			List<List<Integer>> outList = new ArrayList<>();
			outList.add(Arrays.asList(1, 3, 5, 7, 8, 9, 10));
			outList.add(Arrays.asList(2, 4, 6, 7, 8, 9, 10));
			outList.stream().flatMap(innerList -> innerList.stream()).distinct().filter(n -> n % 2 == 0).sorted(); // [2,4,6,8,10]
		}
	}

	// @ 결과 추출하기
	public void extractResult() {
		{ // Stream 기본 제공 결과값
			long count = Arrays.asList("One", "Two", "Three", "Four").stream().count();
			boolean anyMatch = Arrays.asList("One", "Two", "Three", "Four").stream().anyMatch(word -> word.equals("One"));
			boolean allMatch = Arrays.asList(1, 2, 3).stream().allMatch(n -> n < 4);
			int sum = IntStream.range(1, 10).sum();
			double average = IntStream.range(1, 10).average().getAsDouble();
			int any = Arrays.stream(new int[] { 1, 2, 3 }).boxed().findAny().get();
		}

		{ // collect 
			Arrays.stream(new int[] { 1, 2, 3 }).boxed().collect(Collectors.toList());

			Supplier<List<Integer>> supplier = () -> new ArrayList<>();
			ObjIntConsumer<List<Integer>> accumulator = (list, i) -> list.add(i);
			BiConsumer<List<Integer>, List<Integer>> combiner = (list1, list2) -> list1.addAll(list2);
			Arrays.stream(new int[] { 1, 2, 3 }).collect(supplier, accumulator, combiner);
		}

		{ // reduce
			int sum = IntStream.range(1, 10).reduce((left, right) -> left - right).getAsInt();
			String last = Stream.<String>builder().add("Stream").add("너무").add("좋아요").build()
					.reduce((left, right) -> left + " " + right).get();
		}
	}
}
