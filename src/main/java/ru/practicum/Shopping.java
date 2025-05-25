package ru.practicum;

import java.util.Arrays;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        String[] shoppingList = new String[1];
        int productCount = 0;
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = 0;
            while (true) {
                if (scanner.hasNextInt()) {
                    actionNumber = scanner.nextInt();
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("Введите команду из списка.");
                }
            }

            if (actionNumber == 1) {
                productCount++;
                if (productCount == shoppingList.length) {
                    shoppingList = Arrays.copyOf(shoppingList, shoppingList.length + 1);
                    System.out.println("length" + shoppingList.length);
                }
                String line = scanner.next();

                shoppingList[productCount - 1] = line;
                System.out.println("Добавлен: " + productCount + " - " + shoppingList[productCount - 1]);
            } else if (actionNumber == 2) {
                boolean flag1 = false;
                for (String s : shoppingList) {
                    if (s != null) {
                        flag1 = true;
                        break;
                    }
                }
                if (flag1) {
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (shoppingList[i] != null) {
                            System.out.println(i + 1 + " - " + shoppingList[i]);
                        }
                    }
                    System.out.println("Вывод списка.");
                } else {
                    System.out.println("Заполните список.");
                }
            } else if (actionNumber == 3) {
                boolean flag2 = false;
                for (String s : shoppingList) {
                    if (s != null) {
                        flag2 = true;
                        break;
                    }
                }
                if (flag2) {
                    for (int i = 0; i < shoppingList.length; i++) {
                        if (shoppingList[i] != null) {
                            shoppingList[i] = null;
                        }
                    }
                    System.out.println("Очмщен список ");
                } else {
                    System.out.println("Список пуст.");
                }

            } else if (actionNumber == 4) {
                System.out.println("Выход из программы.");
                break;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
