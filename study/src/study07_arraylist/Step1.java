package study07_arraylist;

import java.util.ArrayList;


public class Step1 {

	public static void main(String[] args) {
		ArrayList<String> fruits = new ArrayList<>();

		
		//값추가
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("딸기");
		
		//print
		System.out.println(fruits);
		
		//get index
		System.out.println(fruits.get(0));
		
		//count size()
		System.out.println(fruits.size());
		
		// set()
		System.out.println(fruits.set(1, "자두"));
		System.out.println(fruits);
		
		// remove()
		System.out.println(fruits.remove(0));
		System.out.println(fruits);
		
		
		for(int i=0;i<fruits.size();i++) {
			System.out.println(i + "번째 과일은 " + fruits.get(i));
		}
		
		for(String item:fruits) {
			System.out.println("과일 : " + item);
		}
		
		ArrayList<Integer> num = new ArrayList<Integer>();
		num.add(10);
		num.add(20);
		num.add(30);
		num.add(40);
		
		System.out.println(num);
		
		int sum = 0;
		for(int number:num) {
			sum += number;
		}
		
		System.out.println("합계는 " + sum);
		
	}

}
