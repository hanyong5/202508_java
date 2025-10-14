package study09_interface;

public class CompleteCalc extends Calculator {

	public int v;
	
	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2==0) {
			return 0;
		}else {
			return num1 / num2;
		}
	
	}
	
	public String showInfo() {
		return "완료되었습니다. ";
	}

	

}
