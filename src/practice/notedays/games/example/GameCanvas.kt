package practice.notedays.games

import java.awt.Color
import java.awt.Graphics
import javax.swing.JPanel

abstract class GameCanvas(val stageName: String) : JPanel() {

	override fun paint(g: Graphics) {
		with(createImage(getWidth(), getHeight())) {
			onDraw(getGraphics())
			g.drawImage(this, 0, 0, null)
		}
	}

	abstract fun onDraw(g: Graphics)
	
}