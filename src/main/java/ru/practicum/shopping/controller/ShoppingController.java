package ru.practicum.shopping.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.shopping.service.ShoppingServiceImpl;

@RestController
@RequestMapping(name = "/shopping")
@Slf4j
@RequiredArgsConstructor
public class ShoppingController {
    private final ShoppingServiceImpl shoppingService;
    /*
    Collection<ShoppingDTO> findAll();

    ShoppingDTO create(ShoppingDTO shoppingDTO);

    ShoppingDTO update(ShoppingDTO newShoppingDTO);

    Optional<ShoppingDTO> findById(long id);

    void deleteById(long id);

    void deleteAll();
     */
}