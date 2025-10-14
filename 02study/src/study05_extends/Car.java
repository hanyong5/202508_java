package study05_extends;

public class Car {
	int speed;
	String name;
	

	public Car(int speed,String name) {
		this.speed = speed;
		this.name = name;
	}
	
	public Car(int speed) {
		this.speed = speed;

	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
