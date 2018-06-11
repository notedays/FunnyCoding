package study.basic;

/**
 * # 문법이란? 
 * - 프로그램 작성 시 프로그램이 스스로 판단하고 반복적인 일을 효율적으로 처리할 수 있도록 도와주는 프로그래밍 기법!
 * 
 * # 종류
 * 
 * 	@ 조건문
 * 		i) if문
 *		- if문은 조건을 따져 참인 경우에만 실행하도록 하는 문법으로 프로그래밍이 스스로 작업을 할지 말지 판단하도록 도와준다.
 * 		- 형식  if( true / false ) { 실행할 문장 } (// 뒤부턴 생략가능) else if ( true / false ) { 실행할 문장 } else { 실행할 문장 }
 * 		ex1)
 * 			boolean isMen = false;
 * 			if( isMen ) {
 * 				System.out.println("남자입니다.");
 * 			} else {
 * 				System.out.println("여자입니다.");
 * 			}
 * 		
 * 		ex2)
 * 			int age = 13;
 * 			if( age < 20 ) {
 * 				System.out.print("미성년자 입니다.");
 * 			}
 * 
 * 	@ 반복문
 * 		i) for 문
 * 		- for문은 정해진 횟수만큼 반복할 때 사용하기 편함!
 * 		- 형식  : for(변수 생성 ; 조건 검사; 조건검사후 작업){ 반복 실행할 문장 } 
 * 		ex)	for(int i=0; i<10; i++){
 * 				System.out.println("10번 반복하기!");	
 * 			}		
 * 		
 * 		===========================================================
 * 
 * 		i) while 문 
 * 		- while문은 횟수가 정해져있지 않고 특정 조건 달성까지 반복하는 경우 사용하기 편함!
 * 		- 형식 : while( true or false ) { 반복 실행할 문장 }
 * 		ex) boolean isLoop = true;
 * 			while( isLoop ) {
 * 				System.out.println("반복 실행 중...");
 * 			}
 * 		
 * 		
 * 		i) do ~ while 문 
 * 		- while 문과 비슷하며 최초 한번 실행 후 반복 여부를 체크한다는 차이점이 있음!
 * 		- 형식 : do { 반복할 문장 } while ( true or false );
 * 		ex) boolean isLoop = true;
 * 			do {
 * 				System.out.println("반복 실행 중...");
 * 			} while ( isLoop );
 * 
 * 		===========================================================
 * 
 * 		i) switch case 문
 * 		- switch case 문은 각 case 별로 분기 처리해줘야 할 때 사용하기 편함!
 * 		- 형식 : switch ( key값 ) { case value : 실행문장; .... default : 실행문장; }
 * 		ex) String bread = "초코빵";
 * 			switch(bread){
 * 				case "초코빵" : 
 * 					System.out.println("초코가 들어간 달콤한 빵");
 * 					break;
 *				case "크림빵" :
 *					System.out.println("크림이 들어간 부드러운 빵");
 *					break;
 *				default :
 *					System.out.println("초코빵 또는 크림빵을 선택해주세요!");
 *					break;
 * 			}
 *		
 *		
 *		i) 반복문 탈출 or 이어가기!
 *		- 탈출하기 : break; 또는 return; 명령어로 탈출 가능! ( break : 반복문 범위만 탈출! / return : 메소드 자체를 탈출 )
 *					** (return 의 경우 반복문이 없어도 메소드 종료시 사용!)
 *		
 *		- 이어가기 : continue; 명령어로 이어가기!
 *					continue 를 사용하면 반복문에서 continue 아래에 기술된 문장들을 건너뛰고 다음 반복문을 실행함!
 *
 *		ex) while ( true ) {
 *				System.out.println("반복이 될까?!");
 *				break;
 *			}
 *			-> 이 경우, 한번 실행 후 break를 만났으므로 while 문 종료! 즉 "반복이 될까?!"는 딱 한번 출력됨.
 *
 *			for (int i = 0; i<10; i++){
 *				if(i % 2 == 0){
 *					continue;
 *				}
 *				System.out.println("num : "+i);
 *			}
 *			-> 이 경우 i를 2로 나눈 나머지 값이 0 (즉, 짝수) 인 경우 continue; 를 만나 바로 다음으로 건너뜀.
 *				때문에 홀수  ( 1, 3, 5, 7, 9 ) 의 경우만 출력됨!
 *
 *			** ( % 기호는 나눈 나머지를 구하는 기호! ex) int rest = 10 % 3;  이 때, rest의 값은 10을 3으로 나눈 나머지 1
 */
public class GrammerStudy {

	public GrammerStudy() {
		// # if문
		int age = 13;
		boolean isAdult = age >= 20;
		if (isAdult) { // @ isAdult 대신 age >= 20이 바로 들어가도 됨!
			System.out.println("성인 입니다.");
		} else {
			System.out.println("미성년자 입니다.");
		}
		
		// ================================================================
		
		// # for문
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = sum + i;
		}
		System.out.println("1 ~ 10 까지 합은 ? " + sum);

		// ================================================================
		
		// # while문
		int count = 0;
		while (count < 500) {
			count = count + 1;
			System.out.println("500번 반복할수 있을까? No! 아래에서 count가 2를 넘는 순간 break! ㅜ.ㅜ");

			if (count > 2) { // @ 3번 반복후 break; 되도록!
				break;
			}
		}
		
		// # do ~ while 문
		boolean isLoop = true;
		do {
			System.out.println("반복 실패 : isLoop 가 false가 되어버림.. ㅜ.ㅜ");
			isLoop = false;
		} while (isLoop);
		
		// ================================================================
		
		// # switch case 문 : switch case 문의 경우 각 case 마다 break 걸어주지 않으면 맞는 case 아래의 모든 문장이 실행됨을 유의하자!
		// - 아래의 예시에선 puppy 가 "포메라니안" 이라면 default에 정의된 문장도 실행됨!! 
		String puppy = "푸들";
		switch (puppy) {
		case "푸들":
			System.out.println("지능, 성격, 외모부터 상위에 이르는 현대 목적견의 요구조건을 거의 모두 충족시켜 일반적으로 선호되는 애완견이다.");
			break;
		case "포메라니안":
			System.out.println("영국 왕실에서 길렀으며 이젠 전 세계적으로 애완용으로 유명한 품종이다.");
		default:
			System.out.println("현재 등록되지 않은 품종입니다.");
			break;
		}
		
	}

	public static void main(String[] args) {
		new GrammerStudy();
	}
}
