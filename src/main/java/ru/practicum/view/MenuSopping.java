package ru.practicum.view;

import ru.practicum.controller.FactorySopping;
import ru.practicum.model.ManageShopping;

import java.util.Scanner;

public class MenuSopping {
    private Scanner scanner;
    private FactorySopping factorySopping;

    public MenuSopping() {
        scanner = new Scanner(System.in);
        factorySopping = new FactorySopping(new ManageShopping());

    }

    public void game() {
        factorySopping.init();
        System.out.println("Вас приветствует список покупок!");
        while (true) {
            menu();
            String actionNumber = scanner.next();
            if (actionNumber.equals("4")) break;
            switch (actionNumber) {
                case "1":
                    factorySopping.add();
                    break;
                case "2":
                    factorySopping.show();
                    break;
                case "3":
                    factorySopping.clear();
                    break;
                default:
                    System.out.println("Неизвестная команда!");
                    break;
            }
        }
        System.out.println("Выход из программы");
    }

    private void menu() {
        System.out.println("\tВыберите одну из команд:" +
                "\n\t1. Добавить товар в список" +
                "\n\t2. Показать список" +
                "\n\t3. Очистить список" +
                "\n\t4. Завершить работу");
    }

    private void select(String actionNumber) {
        switch (actionNumber) {
            case "1":
                factorySopping.add();
                break;
            case "2":
                factorySopping.show();
                break;
            case "3":
                factorySopping.clear();
                break;
            default:
                System.out.println("Неизвестная команда!");
                break;
        }
    }
}