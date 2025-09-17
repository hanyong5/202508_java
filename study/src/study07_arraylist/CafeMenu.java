package study07_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class CafeMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menu = new ArrayList<>();
		
		
		while(true) {
			System.out.println("=== 카페 메뉴 관리 프로그램 ===");
			System.out.println("1. 메뉴 추가");
			System.out.println("2. 메뉴 보기");
			System.out.println("3. 메뉴 수정");
			System.out.println("4. 메뉴 삭제");
			System.out.println("5. 종료");
			System.out.print("번호를 선택하세요 : ");
			
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼비우기
			
			switch(choice) {
				case 1:
					System.out.print("추가할 메뉴 이름 : ");
					String newMenu = sc.nextLine();
					menu.add(newMenu);
					System.out.println(newMenu + "메뉴가 추가 되었습니다.");
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					System.out.println("프로그램 종료합니다.");
					return;
			}
		}
		
	}

}
