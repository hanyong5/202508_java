package study10_IoC_TV1;

public class TVUser {

	public static void main(String[] args) {
		LgTV tv = new LgTV();
		
//		tv.powerOn();
//		tv.powerOff();
//		tv.volumeUp();
//		tv.volumeDown();
		
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
		
	}

}
