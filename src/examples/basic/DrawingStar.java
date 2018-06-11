package examples.basic;

import util.ConsoleUtil;

/**
 * # for문을 활용한 별 그리기 예제
 * 
 * @ 미리 봐야 할 것
 * - study.basic 패키지의 GrammerStudy에서 for문 선행학습 필요!
 *
 */
public class DrawingStar {
	public static void main(String[] args) {
		new DrawingStar();
	}
	
	// # ConsoleUtil
	ConsoleUtil console = ConsoleUtil.getInstance();
	
	public DrawingStar() {
		while(true) {
			System.out.println("*~ 별 그리기 예제 ~*");
			int num = console.inputNo("별 몇개까지 그릴까요??");
			
			// @ 행을 그리는 for 문
			for (int i = 0; i < num; i++) {
				// @ 채워진 별 그리는 for 문
				for (int j = 0; j <= i; j++) {
					System.out.print("★");
				}
				
				// @ 빈 별 그리는 for 문
				for (int j = i; j < num -1; j++) {
					System.out.print("☆");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
