package ru.practicum.mapper;

import ru.practicum.dto.ShoppingDTO;
import ru.practicum.model.Shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingMapper {
    public static ShoppingDTO toDTO(Shopping shopping) {
        return ShoppingDTO.builder()
                .id(shopping.getId())
                .name(shopping.getName())
                .build();
    }

    public static List<ShoppingDTO> toListDTO(List<Shopping> shoppings) {
        return shoppings.stream().map(ShoppingMapper::toDTO).toList();
    }

    public static Shopping toModel(ShoppingDTO shoppingDTO) {
        return Shopping.builder()
                .id(shoppingDTO.getId())
                .name(shoppingDTO.getName())
                .build();
    }

    public static List<Shopping> toListModel(List<ShoppingDTO> shoppingDTOS) {
        List<Shopping> shoppingList = new ArrayList<>();
        for (ShoppingDTO dto : shoppingDTOS) {
            shoppingList.add(toModel(dto));
        }
        return shoppingList;
    }
}