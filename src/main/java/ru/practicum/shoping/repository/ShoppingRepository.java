package ru.practicum.shoping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.shoping.model.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}