package ru.practicum.service;

import ru.practicum.file.ShoppingFile;
import ru.practicum.model.Shopping;

import java.util.Scanner;

public class ShoppingServiceImpl implements ShoppingService {
    private final ShoppingFile shoppingFile;
    private Scanner scanner;

    public ShoppingServiceImpl(ShoppingFile shoppingFile) {
        this.shoppingFile = shoppingFile;
        scanner = new Scanner(System.in);
    }

    @Override
    public void findAll() {
        if (!shoppingFile.shoppingMap.isEmpty()) {
            for (Shopping shopping : shoppingFile.findAll()) {
                System.out.println(shopping.toString());
            }
            System.out.println("Вывод списка.");
        } else {
            System.out.println("Заполните список.");
        }
    }

    @Override
    public void create() {
        String name = scanner.next();
        Shopping shopping = new Shopping(null,name);
        shopping.setId(getNextId());
        shoppingFile.save(shopping);
        System.out.println("Добавлен: " + shopping.toString());
    }

    @Override
    public void update() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public void deleteAll() {
        System.out.println("Очищен список.");
        shoppingFile.deleteAll();
    }

    private long getNextId() {
        long currentMaxId = shoppingFile.findAll()
                .stream()
                .mapToLong(Shopping::getId)
                .max()
                .orElse(0);
              return ++currentMaxId;
    }
}