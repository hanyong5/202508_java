package study04;

public class HeroTest {
	public static void main(String[] args) {
		String[] ironman = {"레이저","미사일","비행"};
		String[] thor = {"소환","번개일격","망치"};
		String[] hulk = {"펀치","도약","소리지름"};
		String[] spider = {"거미줄타기","벽타기"};
		
		
		
		Hero hero1 = new Hero("아이언맨","하이테크슈트",90,80,ironman);
		Hero hero2 = new Hero("토르","번개",100,80);
		Hero hero3 = new Hero("헐크","주먹",150,150,hulk);
		Hero hero4 = new Hero("스파이더맨","거미줄",70,50,spider);
		
		
		hero1.showHeroInfo();
		hero2.showHeroInfo();
		hero3.showHeroInfo();
		hero4.showHeroInfo();
		
		
	}
}
