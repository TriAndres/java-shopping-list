package ru.practicum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.practicum.model.Shopping;
@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long> {
}