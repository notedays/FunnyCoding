package practice.notedays.games.example

import java.awt.Graphics
import javax.swing.JComponent

abstract class GameObject() : JComponent() {
	abstract fun onDraw(g: Graphics)
}