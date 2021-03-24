package study.java.enums;

public class Monsters {
	private int monsterCode;
	
	public static final int RABBIT = 1;
	public static final int WOLF = 2;
	public static final int NINE_TAIL = 3;
	public static final int DRAGON = 4;
	public static final int DEVIL = 5;
	
	public Monsters(int monsterCode) {
		this.monsterCode = monsterCode;
	}
	
	public String getMonsterName(){
		switch (monsterCode) {
		case RABBIT: return "토끼";
		case WOLF: return "늑대";
		case NINE_TAIL: return "구미호";
		case DRAGON: return "드래곤";
		case DEVIL: return "데빌";
		default: return "No Monster";
		}
	}
	
	public int getMonsterHP(){
		switch (monsterCode) {
		case RABBIT: return 20;
		case WOLF: return 30;
		case NINE_TAIL: return 40;
		case DRAGON: return 50;
		case DEVIL: return 60;
		default: return 0;
		}
	}
	
	public int getMonsterCode() {
		return monsterCode;
	}

	public void setMonsterCode(int monsterCode) {
		this.monsterCode = monsterCode;
	}
	
	
}
