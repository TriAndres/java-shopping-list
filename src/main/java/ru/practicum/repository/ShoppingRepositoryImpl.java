package ru.practicum.repository;

import ru.practicum.model.Shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingRepositoryImpl implements ShoppingRepository {
    public final Map<Long, Shopping> shoppingMap = new HashMap<>();

    @Override
    public Collection<Shopping> findAll() {
        return shoppingMap.values();
    }

    @Override
    public Shopping save(Shopping shopping) {
        return shoppingMap.put(shopping.getId(), shopping);
    }

    @Override
    public void deleteAll() {
        shoppingMap.clear();
    }
}