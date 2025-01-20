package com.example.kiosk.level1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //입력기능을 위한 Scanner 객체생성

        //메뉴배열: 메뉴항목을 문자열 배열에 저장
        String[] item = {
                "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거"
        };

        //기본메뉴 출력
        System.out.println("[ SHAKESHACK MENU ]");
        for(String forItem : item) {
            System.out.println(forItem); //각 메뉴항목 출력
        }
        System.out.println("0. 종료      | 종료"); //종료옵션 출력

        //사용자입력 처리
        while(true) {
            int choice = sc.nextInt(); //메뉴번호 입력받기

            //0 입력 시 프로그램 종료
            if (choice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break; //반복문 종료
            }
            //1<=입력번호<=배열크기일 경우: 해당번호의 메뉴출력
            else if(choice >= 1 && choice <= item.length) {
                    System.out.println(item[choice - 1]); //선택한 메뉴항목 출력
            }
        }
    }
}