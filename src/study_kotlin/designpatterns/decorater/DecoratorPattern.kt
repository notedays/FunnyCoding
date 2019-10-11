package designpatterns.decorater

/*
 # 데코레이터 패턴
 
 i) 어떤 특정 클래스의 코드를 수정하지 않고 해당 클래스의 작업을 원하는대로 확장하기 용이한 패턴
 i) 서브클래스를 만들어서 기능을 유연하게 확장하는 방법
 
 조건 ) 기존의 구현 클래스와 확장할 데코레이터 클래스가 같은 인터페이스를 구현해야 한다.
 
 */
fun main(args: Array<String>) {
	// @ 기본 사이언 구현의 손오반
	val gohan: Saiyan = Gohan()
	println(Super(Super(gohan)))

	// @ Super 로 초사이언 단계를 두번 올린 손오공
	var goku: Saiyan = Goku()
	goku = Super(goku) 
	println(goku)
	goku = Super(goku)
	println(goku)
	goku = Exhaust(goku)
	println(goku)
}

// 드래곤볼 - 사이어인
interface Saiyan {
	override fun toString(): String
}

// 사이어인 인터페이스를 최초 구현 작성한 손오반 (Gohan) 클래스
class Gohan : Saiyan {
	override fun toString(): String = "사이언_손오반"
}

class Goku : Saiyan {
	override fun toString(): String = "사이언_손오공"
}

// 사이어인의 단계를 첨가할 수 있는 Decorator 추상 클래스
abstract class SaiyanDecorator(val saiyan: Saiyan) : Saiyan

// 사이언의 단계를 표현하는 Super 클래스 (기존 Goku 클래스에 첨가할 첨가물 클래스)
class Super(saiyan: Saiyan) : SaiyanDecorator(saiyan) {
	override fun toString(): String = "초$saiyan"
}

class Exhaust(saiyan: Saiyan) : SaiyanDecorator(saiyan) {
	override fun toString(): String = saiyan.toString().replace("초", "")
}
