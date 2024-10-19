package ru.practicum.shoping.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.practicum.shoping.model.Shopping;
import ru.practicum.shoping.repository.ShoppingRepository;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@Repository
public class ShoppingServiceImpl implements ShoppingService {
    private final ShoppingRepository repository;

    @Override
    public Collection<Shopping> findAll() {
        return repository.findAll();
    }

    @Override
    public Shopping create(Shopping shopping) {
        return repository.save(shopping);
    }

    @Override
    public void clear() {
        repository.deleteAll();
    }
}