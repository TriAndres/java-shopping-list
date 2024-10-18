package ru.practicum.shoping.repository;

import ru.practicum.shoping.model.Shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingRepositoryImpl implements ShoppingRepository {
    private final Map<Long, Shopping> shoppings = new HashMap<>();

    @Override
    public Collection<Shopping> findAll() {
        return shoppings.values();
    }

    @Override
    public void create(Shopping shopping) {
        shopping.setId(getNextId());
        shoppings.put(shopping.getId() + 1, shopping);
    }

    @Override
    public void clear() {
        shoppings.clear();
    }

    private Long getNextId() {
        return shoppings.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(1L);
    }
}