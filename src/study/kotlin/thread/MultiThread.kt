package study.kotlin.thread

/*
 # 멀티 스레드

 i) 정의
 - 하나의 프로세스(작업)가 병렬처리를 위해서 작은 프로세서들을 돌리는 것.
 - 스레드간 스택영역만 비공유하고 데이터 영역과 힙영역 공유.
 
 i) 주의 사항
 - 임계영역(Critical Section)
 	- 둘 이상의 스레드가 동시에 실행됐을 때 문제를 일으키는 코드 블럭을 의미.
 	- 하나의 변수(메모리 공간)에 둘 이상의 스레드가 동시에 접근하기 때문.
 	- 이를 해결하기 위해 동기화가 필요함. (synchronize)
 
*/

fun main(args: Array<String>) {
	MultiThread()
}

class MultiThread {

	init {
		// 스레드의 동기화 문제가 없는 case (공유하는 변수 X)
		println("1. 스레드 동기화 문제와 관련 없는 case ")
		Thread({ println("나는 밥을 먹어요.") }).start()
		Thread({ println("나는 코딩을 해요.") }).start()
		Thread.sleep(1000)

		// 스레드의 동기화 문제가 발생하는 case
		println("\n2. 스레드 동기화 문제가 발생하는 case ")
		var money = 0
		for (name in listOf("코딩", "커피숍", "공장")) {
			Thread {
				for (j in 1..2) {
					money += 100
					println("$name 알바 후 잔고 : $money")
				}
			}.start()
		}
		Thread.sleep(1000)

		// 스레드 동기화 처리된 case
		money = 0
		println("\n3. 스레드 동기화 처리된 case ")
		for (name in listOf("코딩", "커피숍", "공장")) {
			Thread {
				for (j in 1..2) {
					synchronized(money) {
						money += 100
						println("$name 알바 후 잔고 : $money")
					}
				}
			}.start()
		}
	}
}

class MultiThreadExample {
	val HEIGHT = 5
	val WIDTH = 4

	var materialList: MutableList<String> = mutableListOf()

	init {
		// 생성된 재료로 실제 건물을 짓는 빌더 스레드
		Thread {
			while (true) {
				synchronized(materialList) {
					while (!materialList.isEmpty()) {
						print(materialList.removeAt(0))
					}
					println()
				}
				Thread.sleep(50)
			}
		}.start()

		// 재료를 생산하는 스레드
		Thread {
			while (true) {
				synchronized(materialList) {
					print("재료 생산 중")
					for (i in 0..WIDTH) {
						Thread.sleep(1000)
						print(".")
						materialList.add("$i")
					}
				}
				Thread.sleep(50)
			}
		}.start()
	}
}