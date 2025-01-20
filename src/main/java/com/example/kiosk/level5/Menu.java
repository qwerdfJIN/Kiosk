package com.example.kiosk.level5;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName; //카테고리 이름
    private List<MenuItem> menuItems; //카테고리 내 메뉴

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    //메뉴 항목 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    //카테고리 출력
    public static void displayCategory(List<Menu> menus) {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + ". " + menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료      | 종료");
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
