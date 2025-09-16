package study05_extends;

public class DogTest {

	public static void main(String[] args) {
		Dog myfat = new Dog("퍼피",5);
		Cat mycat = new Cat("나비",3);

		
//		myfat.name = "퍼피";
//		System.out.println(myfat.name);
		myfat.showInfo();
		System.out.println(myfat.toString());
		myfat.makeSound();
		
		System.out.println(mycat.toString());
		mycat.makeSound();

	}

}
