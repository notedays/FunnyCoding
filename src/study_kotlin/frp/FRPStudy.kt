package study_kotlin.frp

import util.Music
import java.util.Scanner

/*
# FRP - Functional Reacitve Programming
 
 - 기존의 명령형 (Imperative) / 객체지향 (OOP) 과 같이 프로그래밍 패러다임의 하나
 - 함수형 프로그래밍 + 반응형 프로그래밍의 형태
 - 옵저버 패턴의 활용으로 프로그램의 복잡도 하락
 - 각 코드의 결합도를 느슨하게 해주고 순서에 영향받지 않도록 해줌
 */

fun main(args: Array<String>) {
	SelfFRP()
}

// # 1 간단한 예제 코드 직접 만들어보기
class SelfFRP {

	// 관찰자 Subscriber
	interface Observer<T> {
		fun onAnnounced(data: T)
	}

	// 관찰 가능한 Observable
	interface Observable<T> {
		fun onObserved(subscriber: Observer<T>)
		fun announce(data: T)
	}

	init {
		val me = object : Observable<String> {
			var observer: Observer<String>? = null
			override fun onObserved(subscriber: SelfFRP.Observer<String>) {
				this.observer = subscriber
			}

			override fun announce(data: String) {
				observer?.onAnnounced(data)
			}

			fun start() {
				var isOn = true
				val scanner = Scanner(System.`in`)
				while (isOn) {
					print("명령어 입력 : ")
					val announcement = scanner.nextLine()
					when (announcement) {
						"종료" -> isOn = false
						else -> announce(announcement)
					}
					println()
				}
			}
		}

		val observer = object : Observer<String> {
			var music: Music? = null

			override fun onAnnounced(data: String): Unit = when (data) {
				"음악 틀어줘" -> {
					val musicName = "TryEveryThing.mp3"
					music = Music("music/$musicName", false)
					music?.start()
					println("음악 재생 중... $musicName")
				}
				"음악 꺼줘" -> {
					music?.close()!!
					println("음악 종료")
				}
				else -> println("명령어를 찾지 못했습니다 - $data")
			}
		}

		me.onObserved(observer)
		me.start()
	}
}