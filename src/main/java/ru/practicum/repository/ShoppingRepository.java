package ru.practicum.repository;

import ru.practicum.model.Shopping;

import java.util.Collection;

public interface ShoppingRepository {
    Collection<Shopping> findAll();

    Shopping save(Shopping shopping);

    void deleteAll();
}