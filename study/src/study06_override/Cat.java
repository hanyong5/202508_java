package study06_override;

public class Cat extends Animal {

	String color;

	public Cat(String name, int age) {
		super(name, age);
	}

	public void scratch() {
		System.out.println(name + "이 할퀴기 공격을 합니다.");
	}

	@Override
	public void makeSound() {
		System.out.println(name + "이 야옹 소리를 냅니다.");
	}

}
