package ru.practicum.controller;

import ru.practicum.file.ShoppingFile;
import ru.practicum.service.ShoppingServiceImpl;

import static ru.practicum.file.ShoppingFile.loadFromFile;

public class ShoppingController {
    private static final String file = "src\\main\\java\\ru\\practicum\\file\\ShoppingFile.txt";
    private static final ShoppingFile shoppingFile = loadFromFile(file);

    public static ShoppingServiceImpl shoppingServiceImpl() {
        return new ShoppingServiceImpl(shoppingFile);
    }
}