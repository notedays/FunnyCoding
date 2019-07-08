package basic

/*
 	Kotlin 의 main 메소드는 Class 의 범위 밖에 있음을 명시하자!
 */
fun main(args: Array<String>) {
	A()
}

/*
 i) 클래스 명시할때 클래스명 Study2 옆에 ()가 생략되어 있고 이 ()가 자바의 기본 생성자에 해당
 
 i) 생성자 선언 방법 - 첫번째 (java style)
 	- Overloading 을 통한  여러 타입의 생성자 생성
 */
class A {
	
	init {
		// 이 init의 경우 Java의 static{	} 과 같은 녀석
	}
	
	constructor() {
		print("My name is A")
	}

	constructor(name: String) : this()

	constructor(name: String, age: Int) : this(name)
}

/*
 i) 생성자 선언 방법 - 두번째 (Kotlin style)
 - 아래와 같이 클래스 이름 오른쪽에 한번에 정의하고 default 값 정의를 통해 생략 가능 처리
 */
class B(name: String = "default", age: Int = 0, isMale: Boolean = true)

