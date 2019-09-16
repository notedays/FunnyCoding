package util.sound

import java.io.InputStream

interface SoundPlayer {
	fun play(instream: InputStream)
	fun stop()
}