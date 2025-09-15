package study05_extends;

public class Hero {
	String name;
	String power;
	int attack;
	int defense;
	String rank;

	
	public Hero(String name, String power, int attack, int defense) {
		this.name = name;
		this.power = power;
		this.attack = attack;
		this.defense = defense;
		this.rank = calculateRank();
	}

	public String calculateRank() {
		int score = attack + defense;
		
		if(score >= 180) {
			return "S";
		}else if(score >= 140) {
			return "A";
		}else if(score >= 100) {
			return "B";
		}else {
			return "C";
		}
	}
	
	public void showHeroInfo() {
		System.out.println("=======================");
		System.out.println("히어로이름 : " + name);
		System.out.println("능력 : " + power);
		System.out.println("공격력 : " + attack);
		System.out.println("방어력 : " + defense);
		System.out.println("등급 : " + rank);
		System.out.println("=======================");
	}
	
	
	
	
	
	
}
