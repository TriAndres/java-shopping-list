package ru.practicum.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.shopping.model.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}