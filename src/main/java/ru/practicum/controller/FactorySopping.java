package ru.practicum.controller;

import ru.practicum.file.FileShopping;
import ru.practicum.model.ManageShopping;
import ru.practicum.model.Shopping;

import java.util.ArrayList;
import java.util.Scanner;

public class FactorySopping {
    private final ManageShopping manageShopping;
    private  FileShopping fileShopping;

    public FactorySopping(ManageShopping manageShopping) {
        this.manageShopping = manageShopping;
        fileShopping = new FileShopping();
    }

    public void init() {
        if (!fileShopping.getFile().isEmpty()) {
            manageShopping.setList(fileShopping.getFile());
        } else {
            manageShopping.setList(new ArrayList<>());
        }
    }

    public void add() {
        System.out.println("Введите товар:");
        Shopping sh = new Shopping(new Scanner(System.in).next());
        if (isShopping(sh)) {
            manageShopping.add(sh);
            fileShopping.setFile(manageShopping.getList());
            System.out.println("Tовар " + sh.getName() + " добавлен в список под номером " + sh.getId());
        } else {
            System.out.println("Такой товар уже есть в списке.");
        }
    }

    public void show() {
        if (!manageShopping.getList().isEmpty()) {
            for (Shopping shopping : manageShopping.getList()) {
                System.out.println("id-" + shopping.getId() + " name-" + shopping.getName());
            }
            System.out.println("Выведен весь список.");
        } else {
            System.out.println("Заполните список.");
        }

    }

    public void clear() {
        manageShopping.clear();
        System.out.println("Весь список удалён.");
    }

    public boolean isShopping(Shopping shopping) {
        for (Shopping sh : manageShopping.getList()) {
            if (sh.getName().equals(shopping.getName())) {
                return false;
            }
        }
        return true;
    }
}
