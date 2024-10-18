package ru.practicum.shoping.console;

import ru.practicum.shoping.file.ShoppingFile;
import ru.practicum.shoping.repository.ShoppingRepositoryImpl;
import ru.practicum.shoping.service.ShoppingServiceImpl;

import java.util.Scanner;

public class ShoppingConsole {
    private final Scanner sc = new Scanner(System.in);
    private ShoppingServiceImpl ss;
    private ShoppingRepositoryImpl sr;
    private ShoppingFile sf;

    public ShoppingConsole() {
        sr = new ShoppingRepositoryImpl();
        sf = new ShoppingFile();
        ss = new ShoppingServiceImpl(sc, sr, sf);
    }
    public void game() {
        ss.createAll();
        System.out.println("Вас приветствует список покупок!");
        while (true) {
            String line = menu();
            if (line.equals("4")) break;
            select(line);
        }
        System.out.println("Вышли из программы.");
    }

    private String menu() {
        System.out.println("\tВыбирите действие:\n" +
                "\t1 - Добавить товар в список\n" +
                "\t2 - Показать список\n" +
                "\t3 - Очистить список\n" +
                "\t4 - Завершить работу\n");
        return sc.next();
    }

    private void select(String line) {
        switch (line) {
            case "1":
                ss.create();
                break;
            case "2":
                ss.findAll();
                break;
            case "3":
                ss.clear();
                break;
            default:
                System.out.println("Выбирите верное действие!");
        }
    }
}