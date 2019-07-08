package basic

fun main(args: Array<String>) {
	var day3 = Day3_A()
	day3.caller("Hey", ::println)
}


class Day3_A {

	/*
 	i) 함수의 경우 fun 으로 명시하며 자바와는 다르게 리턴값을 가장 마지막에 명시하는 차이가 있음.
 	--> 아래 예시의 Unit 은 자바의 void 와 같음 즉, 리턴값 X
	 */
	fun sing(): Unit {
		println("Try everything~~~ ♪")
	}

	// 위와 같이 하나의 문장으로 기술된 함수의 경우 간단화 가능
	fun sing(song: String) = println(song)

	/*
	i) 함수 자체를 변수에 담을 수도 있는데 이는 자바의 인터페이스 변수를 생각하면 된다.
     */
	var say = { text: String -> println(text) }

	fun sayCaller(text: String) = say(text)
			
	fun caller(text:String, callFun: (text:String) -> Unit) {
		callFun.invoke(text)
	}
}

