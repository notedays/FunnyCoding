package util.sound

import javazoom.jl.player.Player
import java.io.BufferedInputStream
import java.io.InputStream

class Mp3Player : SoundPlayer {
	var player: Player? = null

	override fun play(instream: InputStream) {
		stop()
		
		player = Player(BufferedInputStream(instream))
		instream.use {
			player?.play()
		}
	}

	override fun stop() {
		player?.close()
	}
}