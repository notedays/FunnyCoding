package study.kotlin.designpatterns.observer

import java.util.Observable
import java.util.Observer

/*
 # Java API에서 제공하는 인터페이스 활용한 Observer패턴
 
 i) java.util.Observable (class)
 - 옵저버에게 실제로 알림을 주는 Subject 역할이 미리 구현된 클래스
 
 i) java.util.Observer (interface)
 - 옵저버 인터페이스
 */
fun main(args: Array<String>) {
	val center = WeatherCenter()
	for (i in 1..3) {
		val display = WeatherDisplay(i.toString())
		center.addObserver(display)
	}
	center.changeWeather("흐림")
	center.changeWeather("비")
	center.changeWeather("비")
	center.changeWeather("맑음")
}

class WeatherCenter : Observable() {
	public val name = "기상청"

	private var weather = "맑음"

	public fun changeWeather(weather: String) {
		if (weather != this.weather) {
			setChanged()
		}
		this.weather = weather
		notifyObservers(weather)
	}
}

class WeatherDisplay(val name: String) : Observer {
	override fun update(o: Observable?, weatherText: Any?) {
		println("${name}_DISPLAY :: ${if (o is WeatherCenter) o.name else ""} [ $weatherText ]")
	}
}