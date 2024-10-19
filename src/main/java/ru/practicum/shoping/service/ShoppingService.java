package ru.practicum.shoping.service;

import org.springframework.stereotype.Service;
import ru.practicum.shoping.model.Shopping;

import java.util.Collection;

public interface ShoppingService {
    Collection<Shopping> findAll();

    Shopping create(Shopping shopping);

    void clear();
}