package com.example.kiosk.level6_version1;
import java.util.Scanner;

//메인메뉴 출력 및 선택쿼리
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        Sub sub = new Sub(cart);

        //메인메뉴 카테고리
        String[] mainMenu = {
                "1. Burgers",
                "2. Drinks",
                "3. Desserts",
        };

        //메인메뉴 출력
        while(true) {
            System.out.println("[ MAIN MENU ]");
            for (String forMenu : mainMenu) {
                System.out.println(forMenu);
            }
            //메인메뉴 출력 - 장바구니 비어있으면 추가메뉴 출력
            if (!cart.isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }

            System.out.println("0. 종료      | 종료");

            int mainChoice = sc.nextInt(); //메뉴선택
            sc.nextLine(); //입력버퍼 비우기

            //메인메뉴 선택처리
            switch(mainChoice) {
                case 0: //프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;

                case 1:
                case 2:
                case 3:
                    sub.showSubMenu(mainChoice-1);
                    break;

                case 4:
                    cart.showCart();
                    break;

                case 5:
                    cart.clearCart();
                    System.out.println("진행 중인 주문이 취소되었습니다.");
                    break;
            }
        }
    }
}