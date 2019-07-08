package basic

fun main(args: Array<String>) {
	Day4()
}

/*
# 함수 with / also / apply / let / run 의 정의
 
i) 자기 자신을 반환하는 함수들
 =============================================================
	inline fun <T> T.also(block: (T) -> Unit): T {
	    block(this)
	    return this
	}
	 
	inline fun <T> T.apply(block: T.() -> Unit): T {
	    block()
	    return this
	}
 
 
i) 특정 변환된 데이터 반환 함수
 =============================================================
	inline fun <T, R> with(receiver: T, block: T.() -> R): R {
	    return receiver.block()
	}
	 
	 
	inline fun <T, R> T.let(block: (T) -> R): R {
	    return block(this)
	}
	 
	inline fun <T, R> T.run(block: T.() -> R): R {
	    return block()
	}
   
*/

class Day4 {

	// @ 예제를 위한 임시 클래스들
	data class Person(var name: String? = null, var age: Int? = null) 

	init {
		// @ apply
		Person().apply {
			age = 28
			name = "요코야마"
		}.let { println("${it.name} 씨의 나이는 ${it.age}세 입니다.") }
		println()
		
		// @ also
		Person("카나", null).also {
			it.name?.let { println("이름 : ${it}") }
			it.age?.let { println("나이 : ${it}") }
		}
		println()

		// @ with
		with(Person("카나", 30)) {
			print("${name}는 한국 나이로 ${age}살 입니다.")
		}
		println()
		
	}

}