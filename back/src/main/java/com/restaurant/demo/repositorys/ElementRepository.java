package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.ElementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<ElementModel, Long> {
}
