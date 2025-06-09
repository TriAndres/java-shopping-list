package ru.practicum.shopping.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shopping.dto.ShoppingDTO;
import ru.practicum.shopping.service.ShoppingService;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/shopping")
@RequiredArgsConstructor
@Slf4j
public class ShoppingController {
    private final ShoppingService shoppingService;

    @GetMapping
    public Collection<ShoppingDTO> findAll() {
        log.info("findAll()");
        return shoppingService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingDTO create(@Valid @RequestBody ShoppingDTO shoppingDTO) {
        log.info("create(@RequestBody ShoppingDTO shoppingDTO)");
        return shoppingService.create(shoppingDTO);
    }

    @PutMapping
    public ShoppingDTO update(@RequestBody ShoppingDTO newShoppingDTO) {
        log.info("update(@RequestBody ShoppingDTO newShoppingDTO)");
        return shoppingService.update(newShoppingDTO);
    }

    @GetMapping("/{shoppingId}")
    public Optional<ShoppingDTO> findById(@PathVariable long shoppingId) {
        log.info("findById(@PathVariable long shoppingId)");
        return shoppingService.findById(shoppingId);
    }

    @DeleteMapping("/{shoppingId}")
    public void deleteById(@PathVariable long shoppingId) {
        log.info("deleteById(@PathVariable long shoppingId)");
        shoppingService.deleteById(shoppingId);
    }

    @DeleteMapping
    public void deleteAll() {
        log.info("deleteAll()");
        shoppingService.deleteAll();
    }
}