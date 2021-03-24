package study.java.enums;

public enum MonsterEnum {
	RABBIT(1,"토끼",3,20),
	WOLF(2,"늑대",10,40),
	NINE_TAIL(3,"구미호",20,80),
	DRAGON(4,"드래곤",50,150),
	DEVIL(5,"악마",70,200);
	
	private final int code;
	private final String name;
	private final int attack;
	private final int hp;
	
	private MonsterEnum(int code, String name, int attack, int hp) {
		this.code = code;
		this.name = name;
		this.attack = attack;
		this.hp = hp;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public int getHp() {
		return hp;
	}
	
	
	
}
