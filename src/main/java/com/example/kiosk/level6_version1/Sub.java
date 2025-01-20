package com.example.kiosk.level6_version1;
import java.util.Scanner;

public class Sub {
    private Cart cart;

    //서브메뉴 카테고리
    private final String[][] subMenu = {
            //버거메뉴
            {
                    "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                    "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                    "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                    "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
            },
            //음료메뉴
            {
                    "1. Coke          | W 2.5 | 차가운 콜라",
                    "2. Cider         | W 2.5 | 시원한 사이다",
            },
            //디저트메뉴
            {
                    "1. Icecream      | W 2.5 | 바닐라 아이스크림",
            }
    };

    public Sub(Cart cart) {
        this.cart = cart;
    }

    //서브메뉴 출력
    public void showSubMenu(int subMenuIndex) {
        Scanner sc = new Scanner(System.in);
        String[] currentSubMenu = subMenu[subMenuIndex];
        String subMenuName = "";

        switch(subMenuIndex) {
            case 0:
                subMenuName = "Burgers";
                break;

            case 1:
                subMenuName = "DRINKS";
                break;

            case 2:
                subMenuName = "DESSERTS";
                break;
        }

        System.out.println("[ " + subMenuName + " MENU ]");

        while (true) {
            for (String forCurrentSubMenu : currentSubMenu) {
                System.out.println(forCurrentSubMenu);
            }
            System.out.println("0. 뒤로가기");

            int subChoice = sc.nextInt();
            sc.nextLine();

            if (subChoice == 0) {
                return;
            }

            if (subChoice > 0 && subChoice <= currentSubMenu.length) {
                String selectItem = currentSubMenu[subChoice - 1];
                String itemName = selectItem.split("\\|")[0].split("\\.")[1].trim();
                System.out.println(selectItem);

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");

                int confirm = sc.nextInt();
                sc.nextLine();

                switch (confirm) {
                    case 1:
                        cart.addItem(selectItem);
                        System.out.println(itemName + " 이 장바구니에 추가되었습니다.");
                        return;

                    case 2:
                        continue;
                }
            }
        }
    }
}
