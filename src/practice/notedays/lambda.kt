package practice.lambda

import java.util.Arrays
import java.util.Random
import java.util.Collections

fun main(args: Array<String>) {
	LottoMaker()
}

class LottoMaker {
	init {
		println("____Lotto____")
		var numSet: MutableSet<Int> = mutableSetOf()
		var random = Random()
		while (numSet.size == 6) {
			numSet.add(random.nextInt(46))
		}
		val numList: MutableList<Int> = numSet.toMutableList()
		Collections.sort(numList)
		println("Result :: ${Arrays.toString(numList.toIntArray())}")
	}
}

class Calculator(a: Int, b: Int, c: String) {
	init {
		println("___Calculator___")
		when (c) {
			"+" -> println("a + b = ${a + b}")
			"-" -> println("a - b = ${a - b}")
			"*" -> println("a * b = ${a * b}")
			"/" -> if (b == 0) println("0으로 나눌 수 없음") else println("a / b = ${a / b}")
		}
	}
}

class RandomMatching(name: String) {
	var list: List<String> = arrayListOf("수지", "오나미", "아이유", "장도연", "아라가키", "신봉선", "지수")

	init {
		println("___Random Matching___")
		println("${name}님과 어울리는 짝은 ${list[Math.abs(name.chars().sum()) % list.size]} 입니다")
	}
}

class SortList() {
	var list: List<String> = arrayListOf("A", "B", "C", "D", "E", "F", "G", "AA")

	init {
		for (i in list.sortedByDescending { it.length }) {
			print("${i} ")
		}
		println()
	}
}
