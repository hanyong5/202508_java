package study02;

public class BoxTest {

	public static void main(String[] args) {
		Box b = new Box();
		b.width = 20;
		b.height =20;
		b.length = 20;
		
//		Box c = new Box(20,20,20);
		
		
		
		double result = b.getVolume();
		System.out.println("가로:" + b.width);
		System.out.println("상자의 크기는 " + result);
	}

}
