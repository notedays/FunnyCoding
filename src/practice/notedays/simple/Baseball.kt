package practice.game

import java.util.Arrays
import java.util.Random
import util.ConsoleUtil

fun main(args: Array<String>) {
	BaseBall()
}

class BaseBall {

	val console = ConsoleUtil.getInstance()
	val random: Random = Random()

	init {
		println("_______BaseBall______")
		do {
			var numberLength = console.inputNo("문제 수 입력")
			var numbers: MutableList<Int> = mutableListOf()
			numbers.apply {
				while (numbers.size < numberLength) {
					val randomValue = random.nextInt(9) + 1
					if (!numbers.contains(randomValue)) {
						numbers.add(randomValue)
					}
				}
			}
			var count = 0
			do {
				var strike = 0
				var ball = 0

				println("\n== [${++count}_회전] ==")
				var answer = console.inputText("${numberLength} 자리 숫자 입력")
				if (answer.length != numberLength) {
					continue;
				}

				for (i in 0..numberLength - 1) {
					var answerNo = Integer.parseInt("${answer[i]}")
					if (numbers[i] == answerNo) {
						strike++
					} else if (numbers.contains(answerNo)) {
						ball++
					}
				}

				if (strike == numberLength) {
					println("삼진 아웃!!!! ${Arrays.toString(numbers.toIntArray())}")
					break;
				} else {
					println("S : ${strike} / B : ${ball}")
				}
			} while (true)

		} while (console.inputText("다시 하시겠습니까? Y / N").toUpperCase() == "Y")
		println("게임을 종료합니다.")
	}
}