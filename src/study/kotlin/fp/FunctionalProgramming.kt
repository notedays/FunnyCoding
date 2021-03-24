package study.kotlin.fp

/*
 # 함수형 프로그래밍?

 i) 변경 가능한 상태를 불변상태로 만들어 SideEffect를 없애자!
 - f(x) = y 이 함수의 결과값이 x의 상태에 따라 변해서는 안됨!! --> 이를 통해 SideEffect로부터 안전해짐
 
 i) 함수도 객체다!
 - val add = { a:Int, b:Int -> a + b }
 - 위와 같이 함수를 변수로 정의가 가능!
 
 i) 코드를 간결하게 하고 가독성을 높여 로직에 집중 시키자!
 - 명령형 
 for (i in 0..9) {
	println(i)
 }
 
 - 함수형
 Array(10, { i -> i }).forEach { println(it) }
*/

fun main(args: Array<String>) {
	sum()
	gugudan(2)
}

fun sum() {
	// @ 명령형 프로그래밍
	run {
		var sum = 0
		for (i in 1..7) {
			sum += i
		}
		println("명령형 SUM : $sum")
	}


	// @ 함수형 프로그래밍
	run {
		val add = { a: Int, b: Int -> a + b }
		val sum = { array: Array<Int> -> array.reduce(add) }
		println("함수형 SUM : ${sum(Array(7, { i -> i + 1 }))}")
	}
}

fun gugudan(dan: Int) {
	// @ 명령형 프로그래밍
	run {
		println("명령형 $dan 단 ")
		for (i in 1..9) {
			println("$dan x $i = ${dan * i}")
		}
	}

	// @ 함수형 프로그래밍
	run {
		println("함수형 $dan 단 ")
		Array(9, { i -> i + 1 }).forEach { println("$dan x $it = ${dan * it}") }
	}
}



