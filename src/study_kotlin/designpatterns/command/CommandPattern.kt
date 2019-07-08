package designpatterns.command

fun main(args: Array<String>) {
	// 리모컨 객체 형성
	val remoCon = RemoteController()
	remoCon.addDevice(SamsungTV())
	remoCon.addDevice(LGHomeKeeper())

	// 첫번째 디바이스 버튼 누르기
	remoCon.onButtonPressed(0, "TURN_ON")
	remoCon.onButtonPressed(0, "WORK")
	remoCon.onButtonPressed(0, "TURN_OFF")

	// 두번째 디바이스 버튼 누르기
	remoCon.onButtonPressed(1, "TURN_ON")
	remoCon.onButtonPressed(1, "WORK")
	remoCon.onButtonPressed(1, "TURN_OFF")
}

interface RemoteControllable {
	fun getName(): String
	fun turnOn();
	fun turnOff();
	fun work(button: String);
}

// 장비들을 관리할 리모컨 클래스
class RemoteController {
	// 디바이스 리스트
	private val deviceList = mutableListOf<RemoteControllable>();

	fun addDevice(device: RemoteControllable) = deviceList.add(device)
	fun removeDevice(device: RemoteControllable) = deviceList.remove(device)

	// 리모컨의 버튼이 눌러졌을때 동작을 처리하는 함수
	fun onButtonPressed(deviceIndex: Int, button: String) {
		when (button) {
			"TURN_ON" -> deviceList[deviceIndex].turnOn()
			"TURN_OFF" -> deviceList[deviceIndex].turnOff()
			else -> deviceList[deviceIndex].work(button)
		}
	}
}

class SamsungTV : RemoteControllable {
	override fun getName(): String = "삼성 TV"

	override fun turnOn() = println("${getName()}가 켜졌습니다.")

	override fun turnOff() = println("${getName()}가 꺼졌습니다.")

	override fun work(button: String) = println("Samsung TV's Monitoring :: $button")
}

class LGHomeKeeper : RemoteControllable {
	override fun getName(): String = "LG 홈키퍼"

	override fun turnOn() = println("${getName()} STATE [ ON ]")

	override fun turnOff() = println("${getName()} STATE [ OFF ]")

	override fun work(button: String) = println("HOME KEEPER IS WORKING....")
}