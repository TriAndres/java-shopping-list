package ru.practicum.shopping.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingDTO {
    private Long id;
    private String name;
}