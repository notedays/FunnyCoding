package practice.game

import java.util.Arrays
import java.util.Random
import util.ConsoleUtil

fun main(args: Array<String>) {
	BaseBall()
}

class BaseBall {

	private val console = ConsoleUtil.getInstance()

	init {
		println("_______BaseBall______")
		do {
			val numberLength = console.inputNo("문제 수 입력")
			val numbers: List<Int> = BaseballNumberGenerator.generateNumbers(numberLength)

			var count = 0
			do {
				var strike = 0
				var ball = 0

				println("\n== [${++count}_회전] ==")
				val answer = console.inputText("$numberLength 자리 숫자 입력")
				if (answer.length != numberLength) {
					continue;
				}

				for (i in 0 until numberLength) {
					val answerNo = Integer.parseInt("${answer[i]}")
					if (numbers[i] == answerNo) {
						strike++
					} else if (numbers.contains(answerNo)) {
						ball++
					}
				}

				if (strike == numberLength) {
					println("삼진 아웃!!!! ${numbers.toIntArray().contentToString()}")
					break;
				} else {
					println("S : $strike / B : $ball")
				}
			} while (true)

		} while (console.inputText("다시 하시겠습니까? Y / N").toUpperCase() == "Y")
		println("게임을 종료합니다.")
	}

	object BaseballNumberGenerator {
		fun generateNumbers(numberLength: Int): List<Int> = mutableListOf<Int>().apply {
			while (this.size < numberLength) {
				val randomValue = Random().nextInt(9) + 1
				if (!this.contains(randomValue)) {
					this.add(randomValue)
				}
			}
		}
	}
}

