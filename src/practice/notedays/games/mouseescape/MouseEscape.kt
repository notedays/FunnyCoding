package practice.notedays.games.mouseescape

import practice.notedays.games.GameApp
import practice.notedays.games.GameCanvas
import java.awt.event.MouseEvent

fun main(args: Array<String>) {
	MouseEscape()
}

class MouseEscape : GameApp("Mouse Escape", 900, 600) {
	
	init {
		
	}
	
	override fun makeCanvas(): GameCanvas = MouseEscapeLevel1()
}