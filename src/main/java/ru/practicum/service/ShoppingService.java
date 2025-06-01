package ru.practicum.service;

import ru.practicum.model.Shopping;

import java.util.Collection;
import java.util.Optional;

public interface ShoppingService {
    Collection<Shopping> findAll();

    Shopping create();

    Shopping update();

    Optional<Shopping> findById(long id);

    void deleteById(long id);

    void deleteAll();
}
