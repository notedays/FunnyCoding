package study.kotlin.designpatterns.command

fun main(args: Array<String>) {
	// 리모컨 객체 형성
	val remoCon = RemoteController()
	remoCon.addDevice(SamsungTV())
	remoCon.addDevice(LGHomeKeeper())
	remoCon.addDevice(
		CustomDevice(
			{ println("커스텀 장치 ON") },
			{ println("커스텀 장치 OFF") },
			{ println("$it 버튼 호출") })
	)

	for (index in 0 until remoCon.deviceList.size) {
		remoCon.onButtonPressed(index, "TURN_ON")
		remoCon.onButtonPressed(index, "WORK")
		remoCon.onButtonPressed(index, "TURN_OFF")
	}
}

interface RemoteControllable {
	fun turnOn();
	fun turnOff();
	fun work(button: String);
}

// 장비들을 관리할 리모컨 클래스
class RemoteController {
	// 디바이스 리스트
	val deviceList = mutableListOf<RemoteControllable>();

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
	override fun turnOn() = println("삼성 TV가 켜졌습니다.")

	override fun turnOff() = println("삼성 TV가 꺼졌습니다.")

	override fun work(button: String) = println("Samsung TV's Monitoring :: $button")
}

class LGHomeKeeper : RemoteControllable {
	override fun turnOn() = println("LG 홈키퍼 STATE [ ON ]")

	override fun turnOff() = println("LG 홈키퍼 STATE [ OFF ]")

	override fun work(button: String) = println("HOME KEEPER IS WORKING....")
}

class CustomDevice(
	val onAction: () -> Unit,
	val offAction: () -> Unit,
	val work: (String) -> Unit
) : RemoteControllable {
	override fun turnOn() = onAction.invoke()

	override fun turnOff() = offAction.invoke()

	override fun work(button: String) = work.invoke(button)
}
