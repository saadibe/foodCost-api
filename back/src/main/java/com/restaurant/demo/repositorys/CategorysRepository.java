package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorysRepository extends JpaRepository<CategoryModel, Long> {
}
