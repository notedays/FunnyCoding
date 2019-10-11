package study_kotlin.designpatterns.template

fun main(args: Array<String>) {
	println("===== 템플릿 전 =====")
	Coffee().prepareRecipe()
	Tea().prepareRecipe()

	println("===== 템플릿 후 =====")
	Coffee2().prepareRecipe()
	Tea2().prepareRecipe()
}

// 템플릿 패턴 적용 전
class Coffee {
	fun prepareRecipe() {
		println("\n[${this::class.simpleName}] Recipe!")
		boilWater()
		brewCoffeeGrinds()
		pourInCup()
		addSugarAndMilk()
	}

	fun boilWater() = println("물 끓이는 중")
	fun brewCoffeeGrinds() = println("필터를 통해서 커피를 우려내는 중")
	fun pourInCup() = println("컵에 따르는 중")
	fun addSugarAndMilk() = println("설탕과 우유를 추가하는 중")
}

class Tea {
	fun prepareRecipe() {
		println("\n[${this::class.simpleName}] Recipe!")
		boilWater()
		steepTeaBag()
		pourInCup()
		addLemon()
	}

	fun boilWater() = println("물 끓이는 중")
	fun steepTeaBag() = println("차를 우려내는 중")
	fun pourInCup() = println("컵에 따르는 중")
	fun addLemon() = println("레몬을 추가하는 중")
}


/*
i) 위의 두 클래스는 아래와 같은 공통점을 가진다.
  - 물을 끓인다.
  - 음료를 우려낸다.
  - 컵에 따른다.
  - 추가재료를 추가한다.
 
i) 위의 공통점들을 추상화를 통해 묶을 수 있다.
  - 추상클래스 & 상속의 활용
*/

// # 위의 공통점을 바탕으로 추상클래스를 활용하여 공통되는 코드 제거
abstract class CaffeineBeverage {
	/*
   	# 템플릿 메소드 : prepareRecipe()
 	- 특정 알고리즘에 대한 템플릿(틀)을 제공하는 메소드
	- 알고리즘의 각 단계들을 정의하며, 그 중 한 개 이상의 단계가 서브클래스에 의해 제공될 수 있다.
	 */
	fun prepareRecipe() {
		println("\n[${this::class.simpleName}] Recipe!")
		boilWater()
		brew()
		pourInCup()
		
		if (customerWantsCondiments()) {
			addCondiments()
		}
	}

	fun boilWater() = println("물 끓이는 중")
	fun pourInCup() = println("컵에 따르는 중")

	abstract fun brew()
	abstract fun addCondiments()

	// 후크 메소드 :: 기본적으로 아무 것도 하지않지만 서브 클래스에서 오버라이드를 통해 구현하여 알고리즘에 끼어들 수 있도록 하는 메소드
	open fun customerWantsCondiments() = true
}

class Coffee2 : CaffeineBeverage() {
	override fun brew() = println("필터를 통해서 커피를 우려내는 중")
	override fun addCondiments() = println("설탕과 우유를 추가하는 중")
	
	override fun customerWantsCondiments() = false
}

class Tea2 : CaffeineBeverage() {
	override fun brew() = println("차를 우려내는 중")
	override fun addCondiments() = println("레몬을 추가하는 중")
}