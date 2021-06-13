package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from product_recipe where product = :product_id", nativeQuery = true)
    void clearRecipeList(@Param("product_id") Long product_id);
}
