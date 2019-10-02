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

class Personality(val name: String, val month: Int, val day: Int) {
	val monthArray = arrayOf(
		"오지게", "갈수록", "나름", "역대급", "그냥", "완전히", "처음에만", "모두가 인정한", "항상", "장난 아니게", "세상", "세계1위"
	)
	val dayArray = arrayOf(
		"급함", "이중인격", "세심함", "싸가지", "덜렁댐", "무뚝뚝", "시끄러움", "애교쟁이", "쫄보", "느림", "루시퍼", "결정장애",
		"노잼", "꿀잼", "츤데레", "꼰대", "뻔뻔함", "사랑스러움", "진지충", "유치함", "다중인격", "쎈척함", "미친 텐션", "분조장",
		"소심함", "천사 of 천사", "질풍노도", "조용함", "욕쟁이", "순진함", "우울함"
	)

	init {
		println("$name (${month}월 ${day}일) : ${monthArray[month - 1]} ${dayArray[day - 1]}")
	}
}
