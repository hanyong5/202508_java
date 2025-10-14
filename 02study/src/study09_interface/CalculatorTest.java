package study09_interface;

public class CalculatorTest {

	public static void main(String[] args) {
		Calc cTest = new CompleteCalc(); 
		Calc cTest2 = new CompleteCalc(); 
		Calc cTest3 = new CompleteCalc(); 
//		CompleteCalc ctest1 = new CompleteCalc();
		
//		cTest.
		
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(cTest.add(num1, num2));
		System.out.println(cTest.substract(num1, num2));
		System.out.println(cTest.times(num1, num2));
		
		
		
		CompleteCalc cTest1 = (CompleteCalc)cTest;
//		cTest1.
		System.out.println(cTest1.showInfo());
	}

}
