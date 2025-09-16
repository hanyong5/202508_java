package study06_override;

public class AnimalTest {

	public static void main(String[] args) {

		Animal mydog1 = new Dog("코코",3);
		Animal mycat1 = new Cat("나비",5);
		
		mydog1.makeSound();
		mydog1.showInfo();
		
		Dog mydog2 = (Dog)mydog1;
		mydog2.wagTail();
		
		System.out.println("==================");
		
		mycat1.makeSound();
		mycat1.showInfo();
		
		Cat mycat2 = (Cat)mycat1;
		mycat2.scratch();
	}

}
