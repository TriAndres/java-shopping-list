package ru.practicum.shopping.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shopping.dto.ShoppingDTO;
import ru.practicum.shopping.model.Shopping;
import ru.practicum.shopping.repository.ShoppingRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static ru.practicum.shopping.mapper.ShoppingMapper.toListDTO;
import static ru.practicum.shopping.mapper.ShoppingMapper.toModel;

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
    public ShoppingDTO update(ShoppingDTO shoppingDTO) {
        return null;
    }

    @Override
    public Optional<ShoppingDTO> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteAll() {

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