package study.kotlin.designpatterns.facade

/**
# 퍼사드 패턴 (Facade Pattern) ?

i) 어떤 서브시스템에 대한 간단한 인터페이스를 제공하기 위한 용도
i) 서브시스템의 클래스들을 캡슐화하지 않으므로 서브시스템의 모든 기능도 접근 가능
 */

fun main(args: Array<String>) {

}

class Tire {
	fun go() = println("바퀴 굴러감")
	fun stop() = println("바퀴 멈춤")
}

class Handle {
	fun left() = println("핸들 왼쪽")
	fun right() = println("핸들 오른쪽")
}

class Gear {
	fun drive() = println("기어 - 주행")
	fun natural() = println("기어 - 중립")
	fun parking() = println("기어 - 주차")
	fun reverse() = println("기어 - 후진")
}

class FacadeCar(
	val tire: Tire,
	val handle: Handle,
	val gear: Gear
) {

	fun drive(direction: String) {
		with(gear) {
			if (direction.contains("후")) reverse() else drive()
		}
		with(handle) {
			if (direction.contains("좌")) left()
			if (direction.contains("우")) right()
		}
		tire.go()
	}

	fun park() {
		tire.stop()
		gear.parking()
	}

}