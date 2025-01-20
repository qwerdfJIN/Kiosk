package com.example.kiosk.level6_version2;

public class MenuItem {
    String name;
    double price;
    String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " | W " + price + " | " + description;
    }
}