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
					if(menu.isEmpty()) {
						System.out.println("등록된 메뉴가 없습니다");
					}else {
						System.out.println("카페메뉴 : ");
						for(int i=0;i<menu.size();i++) {
							System.out.println((i+1) + ". " + menu.get(i));
						}
					}
					break;
				case 3:
					System.out.println("수정할 번호 입력 : ");
					int updateIndex = sc.nextInt()-1;
					sc.nextLine();
					
					
					if(updateIndex >= 0 && updateIndex < menu.size()) {
						System.out.println("새로운 메뉴 이름 : ");
						String updateName = sc.nextLine();
						menu.set(updateIndex, updateName);
						System.out.println("메뉴가 수정되었습니다.");
					}else {
						System.out.println("잘못된 번호입니다.");
					}
					
					break;
				case 4:
					System.out.println("삭제할 메뉴 번호 :");
					int deletIndex = sc.nextInt() -1;
					sc.nextLine();
					
					if(deletIndex >= 0 && deletIndex < menu.size()) {
						String removed = menu.remove(deletIndex);
						System.out.println(removed + "메뉴가 삭제되었습니다.");
					}else {
						System.out.println("잘못된 번호입니다.");
					}
				
					break;
				case 5:
					System.out.println("프로그램 종료합니다.");
					return;
					
				default:
					System.out.println("잘못된 입력입니다.");
			}
		}
		
	}

}
