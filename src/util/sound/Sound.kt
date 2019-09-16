package util

import util.sound.Mp3Player
import util.sound.SoundPlayer
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream

class Sound(val fileName: String, var loopCount: Int = 1) {

	lateinit var player: SoundPlayer

	init {
		val extension = fileName.substringAfterLast(".")
		when (extension) {
			"mp3" -> player = Mp3Player()
			"wav" -> player = Mp3Player()
		}
	}

	fun play() {
		player.play(BufferedInputStream(FileInputStream(File(fileName))))
	}
	
	fun stop() {
		player.stop()
	}
}