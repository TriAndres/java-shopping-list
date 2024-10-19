package ru.practicum.shoping.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shoping.model.Shopping;
import ru.practicum.shoping.service.ShoppingService;

import java.util.Collection;

@RequestMapping("/shopping")
@AllArgsConstructor
@RestController
public class ShoppingController {
    private final ShoppingService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/list")
    public Collection<Shopping> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Shopping create(@RequestBody Shopping shopping) {
        service.create(shopping);
        return shopping;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clear")
    public void clear() {
        service.clear();
    }
}
