package examples.basic;

import util.ConsoleUtil;

/**
 * # 간단한 강아지 백과사전 예제!
 * 
 * @ 알고 있어야 할 내용!
 * - study.basic VariableStudy 를 선행학습 해주세요!
 * - study.basic 패키지의 GrammerStudy를 선행학습 해주세요!
 */
public class PuppyEncyclopedia {
	public static void main(String[] args) {
		new PuppyEncyclopedia();
	}

	// # ConsoleUtil 생성
	ConsoleUtil console = ConsoleUtil.getInstance();

	public PuppyEncyclopedia() {
		System.out.println("*~ 귀여운 강아지 백과사전 ~*");
		while (true) {
			// # 콘솔에서 강아지 품종 입력받기
			String puppy = console.inputText("강아지의 품종을 입력해주세요 [푸들 / 포메라니안 / 말티즈 / 요크셔테리어]");
			
			// # 입력받은 품종에 따라 설명 띄워주기
			System.out.println("\n@ [ "+puppy+" ] 설명");
			switch (puppy) {
			case "푸들":
				System.out.println("프랑스인의 사랑을 듬뿍 받고 있는 프랑스의 국견이다. "
						+ "\n영리하고 애교가 많아 국내에서도 많은 사랑을 받고 있는 품종이다. "
						+ "\n양처럼 곱슬곱슬하고 촘촘한 털을 갖고 있는 푸들은 털이 잘 빠지지 않아 털이 집안에 날리는 것을 싫어하는 사람들이 키우면 좋다.");
				break;
			case "포메라니안":
				System.out.println("지금은 작은 애완견이지만 포메라니안은 북극에서 썰매를 끌던 개들의 후손으로 초창기에는 지금보다 큰 편이었다. "
						+ "\n공처럼 둥글고 풍성하게 부풀어 오른 털이 특징이다. "
						+ "\n여우와 비슷한 깜찍한 얼굴에 작은 눈망울이 매력적이고 보호본능이 생기는 귀여운 품종이다.");
				break;
			case "말티즈":
				System.out.println("체구가 작고 몸통이 길다. 피모는 상당히 길고 하얗다. 우아하고 당당하며, 머리를 독특하게 들고 있다."
						+ "\n아름다운 모습과 온화하고 높은 지능을 지녀 애완용으로 널리 사육되었다."
						+ "\n몸무게는 2~3kg이 평균이지만 큰 종의 경우 5kg까지 된다.");
				break;
			case "요크셔테리어":
				System.out.println("영국의 개 품종 중의 하나이며, 한때 노동자들이 기르던 개이며, 쥐잡기용 강아지로 인기가 높았던 애완견이다. "
						+ "\n성격은 사는 환경에 따라 달라지며 온순한 성격과 천진난방한 성격 두가지 중에 하나를 가지고 있다."
						+ "\n크기는 20~23cm이고, 몸무게는 3kg 전후로 나오며, 움직이는 보석이라는 별칭을 가지고 있다.");
				break;
			default:
				System.out.println("잘못된 품종을 입력하셨습니다.");
				break;
			}
			System.out.println();
		}
	}
}
