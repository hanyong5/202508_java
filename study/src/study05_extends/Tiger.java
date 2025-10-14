package study05_extends;

public class Tiger extends Animal {

	public Tiger(String name,int age) {
		super(name,age);
	}
	
	@Override
	public void makeSound() {
		System.out.println(name + "가 어흥 짖습니다.");
	}
}
