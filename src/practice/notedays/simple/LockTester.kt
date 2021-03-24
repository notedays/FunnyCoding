package practice.notedays.simple

import util.LockUtil

fun main() {
	LockTester()
}

class LockTester {
	var money:Int = 0

	init {
		Thread {
			while (true) {
				Thread.sleep(1000)
				println("돈을 벌어요!")
				for (i in 1..5) {
					Thread.sleep(1000)
					money += 10
					println("Up 현재 Money : $money")
				}
				LockUtil.notify("up")
				LockUtil.wait("down")
			}
		}.start()

		Thread {
			while (true) {
				LockUtil.wait("up");
				Thread.sleep(1000)
				println("돈을 써요")
				for (i in 1..5) {
					Thread.sleep(1000)
					money -= 4
					println("Down 현재 Money : $money")
				}
				LockUtil.notify("down")
			}
		}.start()
	}
}