package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.ConstructionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstructionRepository extends JpaRepository<ConstructionModel, Long> {
}
