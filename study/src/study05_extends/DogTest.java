package study05_extends;

public class DogTest {

	public static void main(String[] args) {
		Dog myfat = new Dog("퍼피",5);
		Cat mycat = new Cat("나비",3);
		
		Animal mydog1 = new Dog("코코",3);
		Animal mycat1 = new Cat("타코",5);
		Animal tigerMan = new Tiger("티거",5);
		
//		myfat.foot = 4;
		
		mydog1.makeSound(); // 멍멍멍
		mycat1.makeSound(); //야옹야옹
		tigerMan.makeSound(); //어흥
		mydog1.toString();
		
		
		

		
//		myfat.name = "퍼피";
//		System.out.println(myfat.name);
		myfat.showInfo();
		System.out.println(myfat.toString());
		myfat.makeSound();
		
		System.out.println(mycat.toString());
		mycat.makeSound();
		
		
		
		
		tigerMan.makeSound();

		

	}

}
