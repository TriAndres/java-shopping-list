package ru.practicum.menu;

import java.util.Scanner;

import static ru.practicum.controller.ShoppingController.shoppingServiceImpl;
import static ru.practicum.menu.ActionOrder.from;

public class ShoppingMenu extends Menu {
    @Override
    String menu() {
        System.out.println("\n\tВыберите одну из команд:" +
                "\n\t1. Добавить товар в список" +
                "\n\t2. Обновить по id товар в список" +
                "\n\t3. Показать по id" +
                "\n\t4. Показать список" +
                "\n\t5. Удалить по id из списка" +
                "\n\t6. Очистить список" +
                "\n\t7. Завершить работу");
        return new Scanner(System.in).next();
    }

    @Override
    void select(String line) {
        switch (from(line)) {
            case ACTION1:
                shoppingServiceImpl().create();
                break;
            case ACTION2:
                shoppingServiceImpl().update();
                break;
            case ACTION3:
                shoppingServiceImpl().findById();
                break;
            case ACTION4:
                shoppingServiceImpl().findAll();
                break;
            case ACTION5:
                shoppingServiceImpl().deleteById();
                break;
            case ACTION6:
                shoppingServiceImpl().deleteAll();
                break;
            case ACTION7:
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