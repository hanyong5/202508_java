package study06_override;

public class Animal {
	String name;
	int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.println("이름 : " + name + ", 나이 : " +age);
	}
	
	public void makeSound() {
		System.out.println(name + "이 소리를 냅니다.");
	}
	
	
}
