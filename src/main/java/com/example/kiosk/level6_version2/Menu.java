package com.example.kiosk.level6_version2;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    String categoryName; //카테고리 이름
    List<MenuItem> menuItems; //카테고리 내 메뉴

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //메뉴 항목 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    //메뉴 출력
    public void displayMenu() {
        System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + 1 + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }
}
