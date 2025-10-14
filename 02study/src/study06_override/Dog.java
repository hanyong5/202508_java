package study06_override;

public class Dog extends Animal {
	String breed;

	public Dog(String name, int age) {
		super(name, age);
	}

	public void wagTail() {
		System.out.println(name + "이 꼬리를 흔듬");
	}

	@Override
	public void makeSound() {
		System.out.println(name + "가 멍멍! 짖습니다.");
	}

}
