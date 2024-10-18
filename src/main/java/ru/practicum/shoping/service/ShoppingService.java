package ru.practicum.shoping.service;

import ru.practicum.shoping.model.Shopping;
import ru.practicum.shoping.repository.ShoppingRepository;

import java.util.Scanner;

public class ShoppingService {
    private final Scanner sc;
    private final ShoppingRepository sr;

    public ShoppingService(Scanner sc, ShoppingRepository sr) {
        this.sc = sc;
        this.sr = sr;
    }

    public void create() {
        System.out.println("Введите добавляемый товар");
        sr.create(new Shopping(sc.next()));
        System.out.println("Добавить товар в список.");
    }

    public void findAll() {
        if (!sr.findAll().isEmpty()) {
            for (Shopping shopping : sr.findAll()) {
                System.out.println(shopping.toString());
            }
            System.out.println("Вывели список.");
        } else {
            System.out.println("Заполнете список.");
        }
    }

    public void clear() {
        sr.clear();
        System.out.println("Очищен список");
    }
}