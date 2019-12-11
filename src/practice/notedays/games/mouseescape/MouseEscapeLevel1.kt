package practice.notedays.games.mouseescape

import practice.notedays.games.GameCanvas
import java.awt.Graphics
import java.awt.Color

class MouseEscapeLevel1 : GameCanvas("level 1") {

	// 배경 그리기
	val background = { g: Graphics ->
		g.setColor(Color.BLACK)
		g.fillRect(0, 0, getWidth(), getHeight())
	}

	// 길 그리기
	val path = { g: Graphics ->
		val pathHeight = getHeight() / 3
		g.setColor(Color.WHITE)
		g.fillRect(0, pathHeight, getWidth(), pathHeight)
	}

	// 플레이어 그리기
	val player = { g: Graphics ->
		val pathHeight = getHeight() / 3
		g.setColor(Color.RED)
		g.fillRect(0, pathHeight * 4 / 3, 50, 50)
	}

	override fun onDraw(g: Graphics) = with(g) {
		background.invoke(g)
		path.invoke(g)
		player.invoke(g)
	}

}