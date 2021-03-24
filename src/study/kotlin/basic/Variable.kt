package study.kotlin.basic

lateinit var name :String
val number:Int by lazy {
	println("number 변수 초기화를 합니다!")
	7
}

fun main() {
	println("main 함수 시작")

	// 변수 초기화 여부
	println(::name.isInitialized)

	// lazy 확인
	println(number)
	println(number)
}

class FoodCourt {

	companion object { // 상수
		const val FOOD_CREAM_PASTA = "크림 파스타"
		const val FOOD_STEAK = "스테이크"
		const val FOOD_PIZZA = "피자"
	}

	fun searchPrice(foodName: String) = when (foodName) {
		FOOD_CREAM_PASTA -> 13000
		FOOD_STEAK -> 60000
		FOOD_PIZZA -> 20000
		else -> 0
	}

}