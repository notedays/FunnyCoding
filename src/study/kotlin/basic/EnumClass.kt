package study.kotlin.basic

fun main() {
	for (food in Food.values()) {
		println("$food (${food.price}원) : ${if (food.isHealty()) "건강 식품" else "기호 식품"}")
	}
}

enum class Food(val description: String, val price: Int) {
	CHICKEN("바삭한 튀김옷과 부드러운 속살이 일품인 치킨", 18000),
	ICECREAM("무더위를 시원하게 날려버릴 차갑고 달콤한 아이스크림", 2000),
	RAMEN("후루룩 소리만 들어도 군침이 도는 국민 간식 라면!", 1000),
	BIBIMBAP("여러 나물과 매콤한 고추장이 어우러진 꿀맛 보증수표 비빔밥", 5000),
	;

	fun isHealty() = this == BIBIMBAP
}