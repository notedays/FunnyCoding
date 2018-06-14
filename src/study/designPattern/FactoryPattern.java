package study.designPattern;

/**
 * # 팩토리 패턴이란 ? 
 * 
 * - 객체 생성의 의존성을 느슨하게 하여 유지 보수 (클래스 갈아끼우기) 등에 용이하도록 하는 패턴
 * - 객체 생성을 팩토리에서 대신 해줌으로서 객체 관리하기가 쉬워진다!
 *
 */
public class FactoryPattern {
	
	
	// # 치킨 인터페이스 - 다양한 치킨 관리를 위해 ( 추상클래스도 가능 )
	interface Chicken {
		String getName();
		String getTaste();
		
		String toString();
	}
	
	class HotFried implements Chicken{
		
		@Override
		public String getTaste() {
			return "바삭한 겉과 부드러운 속살에 베여있는 매콤함이 일품";
		}

		@Override
		public String getName() {
			return "핫후라이드";
		}
		
		@Override
		public String toString() {
			return getName()+" : "+getTaste();
		}
	}
	
	
	// # 치킨 을 생성하는 팩토리 클래스
	abstract class ChickenStore {
		
		ChickenStore(){
			System.out.println("어서오세요! "+this.getClass().getSimpleName()+" 입니다.\n저희 매장에 오신 것을 환영합니다.\n\n**메뉴**");
		}
		
		// @ 치킨 요리하기 추상 메소드 : 이 메소드의 구현을 통해 각각의 매장마다 다른 치킨을 만들 수 있고 하나의 ChickenStore 로 자동으로 관리할 수 있음!
		abstract Chicken cookChicken();
		
	}
	
	class BHC extends ChickenStore {

		@Override
		Chicken cookChicken() {
			return new HotFried();
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(new FactoryPattern().new BHC().cookChicken().toString());
	}
}
