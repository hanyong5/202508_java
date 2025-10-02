package study09_interface;

public class CalculatorTest {

	public static void main(String[] args) {
		Calc cTest = new CompleteCalc(); 
//		CompleteCalc ctest1 = new CompleteCalc();
		
		
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(cTest.add(num1, num2));
		System.out.println(cTest.substract(num1, num2));
		
		CompleteCalc cTest1 = (CompleteCalc)cTest;
		
		System.out.println(cTest1.showInfo());
	}

}
