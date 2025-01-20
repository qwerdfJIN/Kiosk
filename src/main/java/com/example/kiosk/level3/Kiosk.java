package com.example.kiosk.level3;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //메뉴 필드 생성
    List<MenuItem> menuItems;

    //메뉴 데이터 관리
    public Kiosk() {
        this.menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
    }

    //흐름제어
    public void start() {
        Scanner sc = new Scanner(System.in); //입력기능

        System.out.println("[ SHAKESHACK MENU ]");

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println(i + 1 + ". " + item.name + "   | W " + item.price + " | " + item.description); //각 메뉴항목 출력
        }

        System.out.println("0. 종료      | 종료"); //종료옵션 출력

        while (true) {

            //사용자입력 및 예외처리
            try {
                int choice = sc.nextInt();

                //0 입력 시 프로그램 종료
                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                //1<=입력번호<=배열크기일 경우: 해당번호의 메뉴출력
                else if (choice >= 1 && choice <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(choice - 1);
                    System.out.println(choice + ". " + selectedItem.name + "   | W " + selectedItem.price + " | " + selectedItem.description); //선택한 메뉴항목 출력
                }

                //잘못된 입력처리(숫자)
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            }

            //잘못된 입력처리(입력타입)
            catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다");
                sc.nextLine(); //버퍼 정리
            }
        }
    }
}