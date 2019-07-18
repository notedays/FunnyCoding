package util

import java.util.Random

class RandomPicker<O>(val default: O) {
	var savedRate = 0.0f
	var map: MutableMap<O, Float> = mutableMapOf()

	fun add(obj: O, rate: Float) = synchronized(map, {
		if (rate > 0) {
			savedRate = savedRate.plus(rate.div(100))
			map.put(obj, savedRate)
		}
	})

	fun show() {
		map.entries.forEach({ println("${it.key} : ${it.value}") })
	}

	fun pick(): O = synchronized(map, { map.entries.find { it.value > Math.random() }?.key ?: default })

	fun pop(): O {
		val pickObj = pick()
		map.remove(pickObj)
		return pickObj
	}
}
