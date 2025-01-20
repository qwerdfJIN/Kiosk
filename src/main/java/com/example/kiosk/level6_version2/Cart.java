package com.example.kiosk.level6_version2;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<MenuItem> cartItems;

    //장바구니 초기화
    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    //장바구니 메뉴추가
    public void addCart(MenuItem item) {
        cartItems.add(item);
    }

    //장바구니 비어있는지 확인
    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    //장바구니 확인
    public void viewCart() {
        double total = totalPrice();
        System.out.println("[ Orders ]");

        for (MenuItem item : cartItems) {
            System.out.println(item);
        }

        System.out.println("[ Total ]");
        System.out.println("W " + total);
    }

    //장바구니 비우기
    public void clearCart() {
        if (cartItems != null) {
            cartItems.clear();
        }
    }

    //장바구니에 담긴 메뉴 가격 총합
    public double totalPrice() {
        double total = 0;
        for(MenuItem item : cartItems) {
            total += item.price;
        }
        return total;
    }
}

