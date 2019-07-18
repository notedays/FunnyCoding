package practice.notedays.simple

import java.util.Scanner
import java.util.Random
import java.util.Collections
import java.util.Arrays
import util.RandomPicker

fun main(args: Array<String>) {
	MultipleLotto()
}


abstract class LottoMaker {
	init {
		println("____${this::class.java.getSimpleName()}____")
		print("횟수 입력 : ")
		with(Scanner(System.`in`)) {
			lotto(nextInt())
			nextLine()
		}
	}

	abstract fun lotto(loopCount: Int): Unit

	// 중복되지 않는 번호 6자리 뽑는 함수
	fun makeNumberArray(): IntArray {
		var numSet: MutableSet<Int> = mutableSetOf()
		with(Random()) {
			while (numSet.size < 6) {
				numSet.add(nextInt(46))
			}
		}
		val numList: MutableList<Int> = numSet.toMutableList()
		Collections.sort(numList)
		return numList.toIntArray()
	}
}

// # 단순히 바로 랜덤 숫자 6개 뽑는 로또
class SimpleLotto : LottoMaker() {
	override fun lotto(loopCount: Int) {
		for (i in 1..loopCount) {
			println("$i 번째 :: ${Arrays.toString(makeNumberArray())}")
		}
	}
}

// # 우선 10000번의 번호추출을 통해 각각의 출현 갯수를 측정 -> 그 번호의 우선순위를 적용하여 다시 6개 추출
class MultipleLotto : LottoMaker() {

	override fun lotto(loopCount: Int) {
		// 10000번 우선 추출하여 Map에 각각의 출현 횟수 저장
		val map: MutableMap<Int, Int> = mutableMapOf()
		for (i in 1..100000) {
			makeNumberArray().forEach { num -> map.put(num, (map.get(num) ?: 0) + 1) }
		}

		// RandomPicker에 숫자별 출현확률 (출현횟수 / 전체출현횟수 x 100)을 저장 
		val picker = RandomPicker<Int>(0)
		val sum = map.values.sum()
		for (entry in map.entries) {
			val rate = entry.value.toFloat().div(sum).times(100.0f)
			picker.add(entry.key, rate)
		}

		// RandomPicker에서 다시 번호 6개 뽑기 - loopCount만큼 반복
		for (i in 1..loopCount) {
			var numSet: MutableSet<Int> = mutableSetOf()
			while (numSet.size < 6) {
				numSet.add(picker.pick())
			}
			val numList: MutableList<Int> = numSet.toMutableList()
			Collections.sort(numList)
			println("$i 번째 :: ${Arrays.toString(numList.toIntArray())}")
		}
	}
}