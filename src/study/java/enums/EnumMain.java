package study.java.enums;

public class EnumMain {
	public static void main(String[] args) {
		// # 1. extends 하는 법
		Monster monster = new ExtendsMonster();
		System.out.println("체력 "+monster.getHp());
		
		// # 2. Monsters 활용
		Monsters monsters = new Monsters(Monsters.DRAGON);
		System.out.println("체력 : "+monsters.getMonsterHP());
		
		// # 3. Enum 활용
		System.out.println("네임 : "+MonsterEnum.DRAGON.getName());
		System.out.println(Weapons.WOOD_SWORD.getAttack());
		System.out.println(Weapons.WOOD_SWORD.getAttack());
	}
}
