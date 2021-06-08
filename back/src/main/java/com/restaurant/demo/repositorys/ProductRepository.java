package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
