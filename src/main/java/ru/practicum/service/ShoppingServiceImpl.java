package ru.practicum.service;

import ru.practicum.model.Shopping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ShoppingServiceImpl implements ShoppingService {
    @Override
    public Collection<Shopping> findAll() {
        return List.of();
    }

    @Override
    public Shopping create() {
        return null;
    }

    @Override
    public Shopping update() {
        return null;
    }

    @Override
    public Optional<Shopping> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

    }


//    private long getNextId() {
//        long currentMaxId = shoppingFile.findAll()
//                .stream()
//                .mapToLong(Shopping::getId)
//                .max()
//                .orElse(0);
//              return ++currentMaxId;
//    }
}