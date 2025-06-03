package ru.practicum.repository;

import ru.practicum.model.Shopping;

import java.util.Collection;
import java.util.Optional;

public interface ShoppingRepository {
    Collection<Shopping> findAll();

    Shopping save(Shopping shopping);

    Shopping findById(long id);

    void deleteById(long id);

    void deleteAll();
}