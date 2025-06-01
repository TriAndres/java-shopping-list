package ru.practicum.menu;

import java.util.Scanner;

import static ru.practicum.controller.ShoppingController.shoppingServiceImpl;
import static ru.practicum.menu.ActionOrder.from;

public class ShoppingMenu extends Menu {
    @Override
    String menu() {
        System.out.println("\n\tВыберите одну из команд:" +
                "\n\t1. Добавить товар в список" +
                "\n\t2. Показать список" +
                "\n\t3. Очистить список" +
                "\n\t4. Завершить работу");
        return new Scanner(System.in).next();
    }

    @Override
    void select(String line) {
        switch (from(line)) {
            case ACTION1:
                shoppingServiceImpl().create();
                break;
            case ACTION2:
                shoppingServiceImpl().findAll();
                break;
            case ACTION3:
                shoppingServiceImpl().deleteAll();
                break;
            case ACTION4:
                out();
                break;
            case null:
                System.out.println("Неизвестная команда.");
                break;
        }
    }

    @Override
    void out() {
        System.out.println("Выход из программы.");
    }
}