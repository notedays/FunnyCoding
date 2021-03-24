package study.java.enums;

import java.util.Random;

public enum Weapons {
	WOOD_SWORD(1,"목검",10,10,1);
	
	private int weaponCode;
	private String name;
	private int attack;
	private int duration;
	private int levelLimit;
	
	private Weapons(int weaponCode,String name, int attack, int duration, int levelLimit) {
		this.weaponCode = weaponCode;
		this.name = name;
		this.attack = new Random().nextInt(10);
		this.duration = duration;
		this.levelLimit = levelLimit;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getLevelLimit() {
		return levelLimit;
	}

	public void setLevelLimit(int levelLimit) {
		this.levelLimit = levelLimit;
	}
	
	
}
