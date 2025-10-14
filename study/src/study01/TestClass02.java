package study01;

import java.util.Iterator;

public class TestClass02 {

	public static void main(String[] args) {
		String[] str = new String[] { "서울", "부산", "대구" };
		
		int[] num = { 2, 1, 3, 4, 5, 30 };
		int[] name = new int[10];
		
		System.out.println(str.length);

		for (int i = 0; i < str.length; i++) {
			System.out.println("지역[" + i + "]" + str[i]);
		}

		for (String city : str) {
			System.out.println(city);
		}

		for (int item : num) {
			System.out.println(item);
		}

		int sum = 0;
		for (int i : num) {
			sum = sum + i;
		}
		double avg = (double) sum / num.length; // 45 / 6 = 7.5
		// int avg = sum / num.length; // 45 / 6 = 7

		System.out.println("합계는 " + sum + "입니다.");
		System.out.println("평균은 " + avg + "입니다.");

		int min = num[0]; // 2
		for (int n : num) { // 2, 1, 3, 4, 5, 30
			if (n < min) {
				min = n;
			}
		}
		System.out.println("최소값은 " + min);
		
		
		
//		for (int i: name) {
//			System.out.println(i);
//		}
	}

}
