package study05_extends;

public class Dog extends Animal {
	
	int foot;

	public Dog(String name, int age) {
		super(name, age);
//		System.out.println("dog");
	}

//	public void makeSound() {
//		System.out.println(name + "가 멍멍짖습니다.");
//	}
	
	
	

	@Override
	public void makeSound() {
		System.out.println(name + "가 멍멍짖습니다.");
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
	public void dogSkill() {
		System.out.println(name + "달립니다.");
	}

}
