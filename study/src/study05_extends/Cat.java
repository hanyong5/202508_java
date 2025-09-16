package study05_extends;

public class Cat extends Animal {
	public Cat(String name,int age) {
		super(name,age);
	}
	
	public void makeSound() {
		System.out.println(name + "가 야옹야옹 짖습니다.");
	}
	
	
}
