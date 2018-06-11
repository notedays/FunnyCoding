package practice.sohee.basic;

public class Robot {
	
	// # 전역변수
	String name;
	
	public Robot(String name) {// # 지역변수
		this.name = name;
	}
	
	public static void main(String[] args) {
		Robot a = new Robot("a");
		System.out.println(a.name);
		
		Robot b = new Robot("b");
		System.out.println(b.name);
	}
}
