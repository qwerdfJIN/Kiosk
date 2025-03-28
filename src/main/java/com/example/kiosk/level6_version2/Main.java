package com.example.kiosk.level6_version2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Menu 객체 생성
        Menu burgers = new Menu("burgers");
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        drinks.addMenuItem(new MenuItem("Coke", 2.5, "차가운 콜라"));
        drinks.addMenuItem(new MenuItem("Cider", 2.5, "시원한 사이다"));

        Menu desserts = new Menu("Desserts");
        desserts.addMenuItem(new MenuItem("Ice Cream", 2.5, "바닐라 아이스크림"));

        //Menu 리스트 생성
        List<Menu> menus = new ArrayList<>();
        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);

        //Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
