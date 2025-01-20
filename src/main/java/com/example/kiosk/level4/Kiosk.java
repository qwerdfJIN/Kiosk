package com.example.kiosk.level4;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menus;

    public Kiosk(List<Menu> menus) {
        this.menus = menus;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Menu.displayCategory(menus);
            int categoryChoice = sc.nextInt();

            if (categoryChoice == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            Menu selectedMenu = menus.get(categoryChoice - 1);

            while (true) {
                selectedMenu.displayMenu();
                int menuChoice = sc.nextInt();

                if (menuChoice == 0) {
                    break;
                }

                MenuItem selectedItem = selectedMenu.menuItems.get(menuChoice - 1);
                System.out.println("선택한 메뉴: " + selectedItem);
                break;
            }
        }
    }
}
