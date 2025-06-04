package ru.practicum.service;

import ru.practicum.dto.ShoppingDTO;

import java.util.Collection;
import java.util.Optional;

public interface ShoppingService {
    Collection<ShoppingDTO> findAll();

    ShoppingDTO create(ShoppingDTO shoppingDTO);

    ShoppingDTO update(ShoppingDTO shoppingDTO);

    Optional<ShoppingDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}