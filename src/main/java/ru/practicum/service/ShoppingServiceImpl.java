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
        Shopping shopping = new Shopping(null, name);
        shopping.setId(getNextId());
        shoppingFile.save(shopping);
        System.out.println("Добавлен: " + shopping.toString());
    }

    @Override
    public void update() {
        System.out.println("Введите id для вывода элемента из списка.");
        long id = Long.parseLong(scanner.next());
        if (shoppingFile.findAll().contains(shoppingFile.findById(id))) {
            Shopping shopping = shoppingFile.findById(id);
            System.out.println("Введите новое название элемента:");
            shopping.setName(scanner.next());
            shoppingFile.save(shopping);
            System.out.println("Обнавлён элемент по id = " + id);
        } else {
            System.out.println("В списке нет элемента по id = " + id);
        }
    }

    @Override
    public void findById() {
        System.out.println("Введите id для вывода элемента из списка.");
        long id = Long.parseLong(scanner.next());
        if (shoppingFile.findAll().contains(shoppingFile.findById(id))) {
            System.out.println(shoppingFile.findById(id).toString());
            System.out.println("Вывод элемента из списка по id = " + id);
        } else {
            System.out.println("В списке нет элемента по id = " + id);
        }
    }

    @Override
    public void deleteById() {
        System.out.println("Введите id удаляемого элемента из списка.");
        long id = Long.parseLong(scanner.next());
        if (shoppingFile.findAll().contains(shoppingFile.findById(id))) {
            shoppingFile.deleteById(id);
            System.out.println("Удалён элемент из списка по id = " + id);
        } else {
            System.out.println("В списке нет элемента по id = " + id);
        }
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