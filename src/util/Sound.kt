package util

import javazoom.jl.player.Player
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream

class Sound(val fileName: String, val loopCount: Int = 1) {
	companion object {
		val LOOP_INFINITE = 0
	}

	val player: Player = Player(BufferedInputStream(FileInputStream(File("src/resources/sounds/${fileName}"))))

	fun play() = Thread({
		var count = 0
		while (loopCount == LOOP_INFINITE || loopCount > count++) {
			player.play()
		}
	}).start()

	fun stop() = player.close()
}

