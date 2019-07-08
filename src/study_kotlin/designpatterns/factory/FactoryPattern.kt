package designpatterns.factory

import java.util.Collections

/*
 # 팩토리 패턴
 
 i) 객체 생성 관련 코드를 캡슐화 함으로써 한 곳에서 관리하기 용이하도록 한다.
 i) 이로 인해 불필요한 if ~ else 또는 switch ~ case ~ 로부터 자유로워 질 수 있다.
 */
fun main(args: Array<String>) {
	var pizzaStore: PizzaStore = MyPizzaStore()
	pizzaStore.orderPizza("불고기")
	println()
	pizzaStore = PizzaHut()
	pizzaStore.orderPizza("쉬림프 핫갈릭")
}

// 피자 데이터 클래스
open class Pizza(val name: String, val cost: Int, vararg ingredientArray: PizzaIngredient) {
	val ingredientList = listOf(ingredientArray)
	override fun toString(): String = "$name 피자 ($$cost)"
}

class ShrimpPizza : Pizza("쉬림프", 10)

// 앞에서 공부했던 decorater 패턴을 적용 (피자의 자르기, 굽기 등의 형태변환을 관리해주는 패턴)
abstract class ReformedPizza(val pizza: Pizza) : Pizza(pizza.name, pizza.cost) {
	init {
		println("$pizza ${reform()}")
	}

	abstract fun reform(): String
}

class CutPizza(pizza: Pizza) : ReformedPizza(pizza) {
	override fun reform() = "자르기"
}

class BakedPizza(pizza: Pizza) : ReformedPizza(pizza) {
	override fun reform() = "굽기"
}

// 피자 가게 추상클래스 :: 피자 객체를 받아오는 createPizza의 추상화를 통해 피자 생성을 캡슐화 함
abstract class PizzaStore(val name: String) {
	abstract fun createPizza(type: String): Pizza

	fun orderPizza(type: String): Pizza {
		println("$name 에서 $type 피자를 주문합니다...!")

		// 팩토리 패턴으로 인해 피자 생성 부분을 하위 클래스에 넘기므로 PizzaStore 에서는 피자의 포장만 관리할 수 있다.
		var pizza = createPizza(type)
		println("피자 재료 : ${pizza.ingredientList.forEach({ingredient -> ingredient.toString()})}")

		pizza = BakedPizza(pizza) // 굽기
		pizza = CutPizza(pizza) // 자르기

		println("$pizza 배달 완료!")
		return pizza
	}
}

class MyPizzaStore : PizzaStore("동네 피자") {
	override fun createPizza(type: String): Pizza = Pizza("$type", 7, PizzaIngredient("피망"), PizzaIngredient("양파"))
}

class PizzaHut : PizzaStore("피자헛") {
	override fun createPizza(type: String): Pizza = Pizza("$type", 21, PizzaIngredient("새우"), PizzaIngredient("베이컨"))
}


// 피자 재료 인터페이스
class PizzaIngredient(val name: String)
