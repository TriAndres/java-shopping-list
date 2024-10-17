package ru.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping {
    private final Scanner scanner = new Scanner(System.in);
    private final List<String> lists = new ArrayList<>();

    public static void main(String[] args) {
        new Shopping().game();
    }

    public void game() {
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
        return scanner.next();
    }

    private void select(String line) {
        switch (line) {
            case "1":
                create();
                break;
            case "2":
                show();
                break;
            case "3":
                clear();
                break;
            default:
                System.out.println("Выбирите верное действие!");
        }
    }

    private void create() {
        System.out.println("Введите добавляемый товар");
        lists.add(scanner.next());
        System.out.println("Добавить товар в список.");
    }

    private void show() {
        if (!lists.isEmpty()) {
            for (int i = 0; i < lists.size(); i++) {
                System.out.println("id=" + (i + 1) + " name=" + lists.get(i));
            }
            System.out.println("Вывели список.");
        } else {
            System.out.println("Заполнете список.");
        }
    }

    private void clear() {
        lists.clear();
        System.out.println("Очищен список");
    }
}