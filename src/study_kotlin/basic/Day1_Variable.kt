package basic
 
/*
 < Kotlin 공부 - Day 1 > : 변수
 
 i) Kotlin 에서는 모든 변수가 객체이다. ( Java의 primitive 변수 X )
 i) Java의 final에 해당 하는 고정 변수는 val / 가변적인 변수는 var 로 표현한다.
 i) 변수 선언 형식
  - var/val 변수명 : 자료형  (?)
    -------		  		---
	가변/불변				Null 허용여부
   
*/ 
fun main(args: Array<String>) {
	// @ 기본적인 변수 선언 및 활용
//	var helloText:String = null; // 자료형 뒤에 ?가 안붙은 경우 null을 대입하려 하면 컴파일 에러
	var helloText:String? = null; // 자료형 뒤에 ?가 안붙은 경우 null을 대입하려 하면 컴파일 에러
	println(helloText?.length); // 변수?.메소드 호출 시 해당 변수가 null이 아닌 경우 메소드 실행!
	
	// @ String의 경우 ${변수명} $변수명을 통해 "" 문자열 안에서 인식 가능
	var name:String = "명진"; // @ 가변적인 변수는 var(iable)
	val fixedText = "${name}은 집을 나서며 손을 흔들었다."; // @ 고정 적인변수 Java의 final 은 val(ue)
	println(fixedText);
	
	// @ for문 사용
	for(i in 1..10){
		print("$i ")
	}
	println()
	
	// @ while 문 사용
	var i:Int = 10;
	while(i > 0){
		print(i--.toString()+" ")
	}
	println()
	
	// @ when case
	for(i in 1..10) {
		when(i) {
			in 1..2 -> println("${i}_in 1..3")
			in 4..5 -> println("${i}_in 1..5")
		} 
	}
}
