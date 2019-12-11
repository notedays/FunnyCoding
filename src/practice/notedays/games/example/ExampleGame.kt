package practice.notedays.games

import java.awt.Color
import java.awt.Graphics
import java.util.Random

class ExampleGame : GameApp("Example", 900, 600) {

	val random = Random()

	override fun makeCanvas(): GameCanvas = object : GameCanvas("Example") {
		override fun onDraw(g: Graphics) = with(g) {
			color = Color.BLACK
			g.fillRect(0, 0, getWidth(), getHeight())

			color = Color.WHITE
			g.drawLine(0, 0, random.nextInt(getWidth()), random.nextInt(getHeight()))
		}
	}
}

fun main(args: Array<String>) {
	ExampleGame()
}