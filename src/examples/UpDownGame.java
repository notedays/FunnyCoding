package examples;

import java.util.Random;

import util.ConsoleUtil;

public class UpDownGame {

	// # main 메소드
	public static void main(String[] args) {
		new UpDownGame();
	}

	// # ConsoleUtil 변수 선언 & 초기화
	ConsoleUtil console = ConsoleUtil.getInstance();

	// # 생성자 ( Constructor )
	public UpDownGame() {
		while (true) {
			System.out.println("______ Up & Down ______");
			for (Action action : Action.values()) {
				System.out.println(action); // @ toString() 메소드 이해 필요!
			}

			// @ Null이 아닌 Action 생성 -- 잘못된 번후 입력 시 번호 입력 반복 유도
			Action action;
			do {
				int actionNo = console.inputNo("실행할 번호 ", 1, Action.values().length);
				action = Action.fromNo(actionNo);
			} while (action == null);

			switch (action) {
			case START_GAME:
				startGame();
				break;
			case EXIT:
				exit();
				break;
			}
		}
	}

	private void startGame() {
		int min = 10;
		int max = 50;

		// @ 제한 범위 입력 받기
		max = console.inputNo("# 제한 범위를 입력하세요 ( " + min + " - " + max + " )", min, max);

		// @ 범위 내의 번호 생성하기
		int randomNumber = generateNum(max, min);
		System.out.println("\n# 번호 생성이 완료되었습니다.");

		int answer = -1;
		do { // @ 정답을 맞출때까지 반복하면서 범위를 좁혀주기!
			answer = console.inputNo("번호를 입력해주세요 ( " + min + " - " + max + " )", min, max);
			if (answer > randomNumber) {
				System.out.println(answer + "_____Down!!");
				max = answer - 1;
			} else if (answer < randomNumber) {
				System.out.println(answer + "_____Up!!");
				min = answer + 1;
			}
		} while (answer != randomNumber);
		System.out.println("** 아쉽게도 생성된 번호를 고르셨습니다.. 오늘의 내기는 지셨네요... ㅜ.ㅜ **\n");
	}

	private void exit() {
		System.out.println("게임을 종료합니다.");
		System.exit(0);
	}

	/**
	 * # 범위 안의 랜덤한 번호를 생성하는 메소드<br>
	 * - <strong>1 ~ range 범위</strong>의 숫자 생성
	 * @param range
	 * @return
	 */
	private int generateNum(int range, int min) {
		return new Random().nextInt(range - min) + min;
	}

	/**
	 * # UpDownGame 클래스 내부에 임시로 생성한 Action enum (내부 클래스 개념 이해 필요!)
	 * @author Team42
	 *
	 */
	enum Action {
		START_GAME(1, "게임 시작"), EXIT(2, "게임 종료");

		int no;
		String title;

		private Action(int no, String title) {
			this.no = no;
			this.title = title;
		}

		static Action fromNo(int no) {
			for (Action action : Action.values()) {
				if (action.no == no) {
					return action;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return no + ". " + title;
		}
	}
}
