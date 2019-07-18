package practice.lambda

import java.util.Arrays
import java.util.Random
import java.util.Collections
import util.Music
import java.util.Scanner

fun main(args: Array<String>) {
	
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

class SortList {
	var list: List<String> = arrayListOf("A", "B", "C", "D", "E", "F", "G", "AA")

	init {
		for (i in list.sortedByDescending { it.length }) {
			print("${i} ")
		}
		println()
	}
}

class TimePrinter(val timeGap: Long, val text: String) : Thread({
	for (char in text) {
		print(char)
		if (!char.isWhitespace()) {
			Thread.sleep(timeGap)
		}
	}
	println()
})
