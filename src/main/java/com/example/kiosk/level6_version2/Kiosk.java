package com.example.kiosk.level6_version2;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menus; //메뉴리스트
    Cart cart; //장바구니

    //메뉴리스트와 장바구니 초기화
    public Kiosk(List<Menu> menus) {
        this.menus = menus;
        this.cart = new Cart();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            displayCategory();
            int categoryChoice = sc.nextInt();

            if (categoryChoice == 0) {
                break;
            } // 프로그램 종료

            if (categoryChoice >= 1 && categoryChoice <= menus.size()) {
                Menu selectedMenu = menus.get(categoryChoice - 1);
                handleCategory(sc, selectedMenu); // 카테고리 처리
            } // 카테고리 선택

            else if (categoryChoice == menus.size() + 1 && !cart.isEmpty()) {
                handleCart(sc);
            } // 장바구니 확인

            else if (categoryChoice == menus.size() + 2 && !cart.isEmpty()) {
                cart.clearCart();
            } // 장바구니 비우기

            else {
                System.out.println("잘못된 입력입니다.");
            } // 잘못된 입력처리
        }
    }

    //카테고리 출력
    public void displayCategory() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i+1 + ". " + menus.get(i).categoryName);
        }

        if (!cart.isEmpty()) {
            System.out.println((menus.size() + 1) + ". Orders");
            System.out.println((menus.size() + 2) + ". Cancel");
        }

        System.out.println("0. 종료      | 종료");
    }

    //카테고리 처리
    public void handleCategory(Scanner sc, Menu selectedMenu) {
        while (true) {
            selectedMenu.displayMenu();
            int menuChoice = sc.nextInt();

            if (menuChoice == 0) {
                return;
            } //뒤로가기

            if (menuChoice >= 1 && menuChoice <= selectedMenu.menuItems.size()) {
                MenuItem selectedItem = selectedMenu.menuItems.get(menuChoice - 1); //메뉴 선택

                System.out.println("선택한 메뉴: " + selectedItem);
                System.out.println("\"" + selectedItem + "\"");
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");

                int confirm = sc.nextInt();

                if (confirm == 1) {
                    cart.addCart(selectedItem);
                    System.out.println(selectedItem.name + " 이 장바구니에 추가되었습니다.");
                } //장바구니에 메뉴추가

                else if (confirm == 2) {
                    return;
                } //장바구니 메뉴추가 취소

                else {
                    System.out.println("잘못된 입력입니다.");
                } //잘못된 입력처리(장바구니 메뉴추가)

            } else {
                System.out.println("잘못된 입력입니다.");
            } //잘못된 입력처리(메뉴 선택)
        }
    }

    //장바구니 확인 및 주문
    public void handleCart(Scanner sc) {
        System.out.println("아래와 같이 주문하시겠습니까?");
        cart.viewCart(); //장바구니 확인

        System.out.println("1. 주문      2. 메뉴판");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("주문이 완료되었습니다. 금액은 W " + cart.totalPrice() + "입니다."); //주문
            cart.clearCart(); //장바구니 비우기
            return; //메뉴판으로 돌아가기
        } 

        else if (choice == 2) {
            return;
        } //메뉴판으로 돌아가기
        
        else {
            System.out.println("잘못된 입력입니다.");
        } //잘못된 입력처리
    }
}