package practice.notedays.minigame

import util.Music
import util.Sound

fun main(args: Array<String>) {
	Escape()
}

class Escape {
	val text =
		"""비가내리는 날...
 학교의 문은 닫혀버렸고.."""

	init {
		printSlowly(text, 150)
	}

	fun printSlowly(text: String, sleep: Long) {
		text.forEach {
			if (!it.isWhitespace()) {
				Sound("effect/typewriter3.mp3").play()
			}
			print(it)
			Thread.sleep(sleep)
		}
	}
}