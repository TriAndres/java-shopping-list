package ru.practicum.shoping.repository;

import ru.practicum.shoping.model.Shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingRepository {
    private final Map<Long, Shopping> shoppings = new HashMap<>();

    public Collection<Shopping> findAll() {
        return shoppings.values();
    }

    public Shopping create(Shopping shopping) {
        shopping.setId(getNextId());
        shoppings.put(shopping.getId(), shopping);
        return shopping;
    }

    public void clear() {
        shoppings.clear();
    }

    public Long getNextId() {
        return shoppings.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0L);
    }
}