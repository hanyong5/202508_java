package study08_abstract;

public abstract  class Computer {
	int ram;
	int cpu;
	
	public abstract void display();
	
	public abstract void turnOn();
	
	
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
	
}
