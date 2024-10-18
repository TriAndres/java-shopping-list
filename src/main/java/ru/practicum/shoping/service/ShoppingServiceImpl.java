package ru.practicum.shoping.service;

import ru.practicum.shoping.file.ShoppingFile;
import ru.practicum.shoping.model.Shopping;
import ru.practicum.shoping.repository.ShoppingRepositoryImpl;

import java.util.Scanner;

public class ShoppingServiceImpl implements ShoppingService {
    private final Scanner sc;
    private final ShoppingRepositoryImpl sr;
    private final ShoppingFile sf;

    public ShoppingServiceImpl(Scanner sc, ShoppingRepositoryImpl sr, ShoppingFile sf) {
        this.sc = sc;
        this.sr = sr;
        this.sf = sf;
    }

    @Override
    public void create() {
        System.out.println("Введите добавляемый товар");
        sr.create(new Shopping(sc.next()));
        sf.setFile(sr.findAll());
        System.out.println("Добавили товар в список.");
    }

    @Override
    public void createAll() {
        for (Shopping shopping : sf.getFile()) {
            sr.create(shopping);
        }
        System.out.println("Записали товары в список.");
    }

    @Override
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

    @Override
    public void clear() {
        sr.clear();
        System.out.println("Очищен список");
    }
}