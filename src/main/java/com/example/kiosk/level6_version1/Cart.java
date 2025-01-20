package com.example.kiosk.level6_version1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>(); //장바구니 배열

    public boolean isEmpty() {
        return items.isEmpty();
    }

    //장바구니 추가
    public void addItem(String item) {
        items.add(item);
    }

    //장바구니 열람 및 주문
    public void showCart() {
        Scanner sc = new Scanner(System.in);

        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");

        double total = 0;

        //장바구니 출력
        for (String item : items) {
            System.out.println(item);

            //가격총합 출력
            if (item.contains("W")) {
                String totalString = item.substring(item.indexOf("W") + 1).trim().split(" ")[0];
                total += Double.parseDouble(totalString);
            }
            System.out.println("[ Total ]");
            System.out.println("W " + String.format("%.1f", total));
        }

        System.out.println("1. 주문      2. 메뉴판");
        int order = sc.nextInt();

        switch (order) {
            case 1:
                System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n", total);
                clearCart();
                return;

            case 2:
                return;
        }
    }

    public void clearCart() {
        items.clear();
    }
}
