package test01;

import java.util.Scanner;

public class Scan01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 :");
        int num1 = scan.nextInt();
        System.out.print("다음 숫자를 입력하세요 :");
        int num2 = scan.nextInt();

        System.out.println("두수의 합은 : " + (num1 + num2));
        
    }
}
