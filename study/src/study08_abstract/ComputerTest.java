package study08_abstract;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer mycom = new DeskTop();
		
		// 부모는 메소드 이름만 선언, 자식은 메소드를 구현
		mycom.display();

	}

}
