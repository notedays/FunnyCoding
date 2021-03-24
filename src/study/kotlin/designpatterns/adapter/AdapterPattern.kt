package study.kotlin.designpatterns.adapter

/*
 
 # 어댑터 패턴 : 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환할때 사용.
 
 i) When?
 	- 특정 클래스를 다른 인터페이스의 구현체로 변경해야 할 때 사용.
 
 i) How?
 	- 어댑터 클래스에서 목적지 객체를 implements / extends
 	- 어댑터 생성 시에 변환할 출발지 객체를 파라미터로 전달 받아 목적지 객체의 메소드들과 연결
 
 */

fun main(args: Array<String>) {
	val turkeyList: MutableList<Turkey> = mutableListOf()

	turkeyList.add(object : Turkey {
		override fun sound() {
			println("푸드덕 푸드덕~")
		}
	})

	// Duck의 객체를 어댑터를 통해 Turkey 객체로 변환하여 리스트에 포함시키기
	turkeyList.add(TurkeyAdapter(object : Duck {
		override fun sound() {
			println("파닥 파닥~")
		}
	}))

	for (turkey in turkeyList) {
		turkey.sound()
	}
}

interface Duck {
	fun sound()
}

interface Turkey {
	fun sound()
}

class TurkeyAdapter(val duck: Duck) : Turkey {
	override fun sound() {
		duck.sound()
	}
}

