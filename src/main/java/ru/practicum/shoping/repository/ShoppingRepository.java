package ru.practicum.shoping.repository;

import ru.practicum.shoping.model.Shopping;

import java.util.Collection;

public interface ShoppingRepository {
    Collection<Shopping> findAll();

    Shopping create(Shopping shopping);

    void clear() ;
}