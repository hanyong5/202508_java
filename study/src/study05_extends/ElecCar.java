package study05_extends;



public class ElecCar extends Car {

	int battery;

	

	
//	public ElecCar(int speed, String name, int battery) {
//		super(speed,name);
//
//		this.battery = battery;
//
//	}
	

	public ElecCar(int i, String string, int j) {
		super(i,string);
		battery = j;
		
	}


	public void charge(int amout) {
		battery += amout;
		// battery = battery + amount;
	}


	@Override
	public String toString() {
		return "ElecCar [battery=" + battery + ", speed=" + speed + ", name=" + name + "]";
	}
	
	
	
}
