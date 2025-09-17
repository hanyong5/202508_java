package study08_abstract;

public abstract class Computer {
	int ram;
	int cpu;
	
	public abstract void display();
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	
}
