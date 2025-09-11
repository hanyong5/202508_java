package test01;

import java.util.Scanner;

public class Scan02 {
    public static void main(String[] args) {



        // 음료자판기 (메뉴를 제공하고 입력값을 출력하기)
        // 1. 콜라(2000), 2. 사이다(1900), 3. 커피(1800)
        
        Scanner scan = new Scanner(System.in);

        System.out.println("1. 콜라, 2. 사이다, 3. 커피");
        System.out.print("음료 번호를 입력하세요:");

        int menu = scan.nextInt();

        if(menu == 1){
            System.out.println("2000원 입니다.");
        } else if(menu == 2){
            System.out.println("1900원 입니다.");
        } else if(menu == 3){
            System.out.println("1800원 입니다.");
        } else {
            System.out.println("올바른 값을 입력하세요.");
        }

        
        
        
    }
}
