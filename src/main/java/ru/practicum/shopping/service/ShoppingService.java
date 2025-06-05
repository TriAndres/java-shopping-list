package ru.practicum.shopping.service;

import ru.practicum.shopping.dto.ShoppingDTO;

import java.util.Collection;
import java.util.Optional;

public interface ShoppingService {
    Collection<ShoppingDTO> findAll();

    ShoppingDTO create(ShoppingDTO shoppingDTO);

    ShoppingDTO update(ShoppingDTO newShoppingDTO);

    Optional<ShoppingDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
}