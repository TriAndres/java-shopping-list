package ru.practicum.shopping.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shopping.dto.ShoppingDTO;
import ru.practicum.shopping.exception.DoesNotExistException;
import ru.practicum.shopping.model.Shopping;
import ru.practicum.shopping.repository.ShoppingRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static ru.practicum.shopping.mapper.ShoppingMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingServiceImpl implements ShoppingService {
    private final ShoppingRepository repository;

    @Override
    public Collection<ShoppingDTO> findAll() {
        return new ArrayList<>(toListDTO(repository.findAll()));
    }

    @Override
    public ShoppingDTO create(ShoppingDTO shoppingDTO) {
        shoppingDTO.setId(getNextId());
        repository.save(toModel(shoppingDTO));
        log.info("Добавлен в список : " + shoppingDTO.toString());
        return shoppingDTO;
    }

    @Override
    public ShoppingDTO update(ShoppingDTO newShoppingDTO) {
        if (repository.findById(newShoppingDTO.getId()).orElseThrow().getId().equals(newShoppingDTO.getId())) {
            Shopping old = repository.findById(newShoppingDTO.getId()).orElseThrow();
            old.setName(newShoppingDTO.getName());
            repository.save(old);
            log.info("Обнавлён элемент по id = {}", old.getId());
            return toDTO(old);
        }
        log.info("Ошибка при обновлении.");
        throw new DoesNotExistException("Элемент отсутствует в списке.");
    }

    @Override
    public Optional<ShoppingDTO> findById(long id) {
        if (repository.findAll().contains(repository.findById(id).orElseThrow())) {
            log.info("Вывод элемента из списка по id = " + id);
            return Optional.ofNullable(toDTO(repository.findById(id).orElseThrow()));
        }
        log.info("В списке нет элемента по id = {}", id);
        throw new DoesNotExistException("Элемент отсутствует в списке.");
    }

    @Override
    public void deleteById(long id) {
        if (repository.findAll().contains(repository.findById(id).orElseThrow())) {
            log.info("Элемент удалён из списка по id = {}", id);
            repository.deleteById(id);
        }
        log.info("В списке нет элемента по id = " + id);
        throw new DoesNotExistException("Элемент отсутствует в списке.");
    }

    @Override
    public void deleteAll() {
        log.info("Очищен список.");
        repository.deleteAll();
    }

    private long getNextId() {
        long currentMaxId = repository.findAll()
                .stream()
                .mapToLong(Shopping::getId)
                .max()
                .orElse(0);
        return ++currentMaxId;
    }
}