package study.kotlin.basic

fun main() {
	Zip()
}

class ForEach {
	val fruits = listOf("바나나", "사과", "귤", "파인애플")

	init {
		// 1단계 일반 for문
		for (fruit in fruits) {
			println(fruit)
		}

		// 2단계 foreach 사용
		fruits.forEach { fruit -> println(fruit) }
		fruits.forEach { println(it) }

		// 3단계 foreach + 참조 함수 사용
		fruits.forEach(::println)
	}
}

data class Person(val name: String, val birthYear: Int)

val people = listOf(
		Person("시아", 2003),
		Person("유나", 2001),
		Person("하은", 2003)
)

class Associate {
	init {
		val personMap: Map<String, Person> = people.associateBy { it.name }
		val personMap2: Map<String, Int> = people.associate { Pair(it.name, it.birthYear) }

		val personMap3: MutableMap<String, Person> = mutableMapOf()
		people.associateByTo(personMap3) { it.name }

		val personMap4: MutableMap<String, Int> = mutableMapOf()
		people.associateTo(personMap4) { Pair(it.name, it.birthYear) }

		val personMap5: Map<Person, Int> = people.associateWith { it.birthYear }
		val personMap6: MutableMap<Person, Int> = mutableMapOf()
		people.associateWithTo(personMap6) { it.birthYear }
	}
}

// 특정한 값을 T로 지정하여 해당 값을 가진 객체를 같은 배열에 모아주는 함수
class GroupBy {
	init {
		val ageGroupingList: Map<Int, List<Person>> = people.groupBy { it.birthYear }
		val nameGroupingList: Map<String, List<Int>> = people.groupBy({ it.name }, { it.birthYear })
	}
}

class Partition {
	init {
		val pair: Pair<List<Person>, List<Person>> = people.partition { it.birthYear >= 2003 }
		val (over03, under03) = people.partition { it.birthYear >= 2003 }
		over03.forEach(::println)
		under03.forEach(::println)
	}
}

class Zip {
	val names = listOf("A", "B", "C", "D")
	val numbers = listOf(-3, 7, 2, -10, 1)

	init {
		println(numbers.flatMap { listOf(it * 10, it + 10) })
		println(numbers.getOrElse(0) { 40 })
		println(numbers.getOrElse(10) { "NO VALUE AT $it" })
		println(names zip numbers)
		val zipArray = names zip numbers
		println(zipArray.flatMap { listOf(it.first, it.second) })
	}
}

