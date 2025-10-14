package study05_extends;

public class ElecCarTest {

	public static void main(String[] args) {
		ElecCar obj = new ElecCar(10,"테스터",100);
		
//		obj.speed = 10; 
		
		System.out.println(obj);
		
		obj.charge(10);
		System.out.println(obj.toString());
		
		obj.setSpeed(20);
		System.out.println(obj);
		
		obj.name = "햄스터";
		System.out.println(obj);
	}

}
