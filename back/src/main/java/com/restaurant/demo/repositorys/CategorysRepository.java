package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorysRepository extends JpaRepository<CategoryModel, Long> {

    @Query( value = "select * from categorys where LOWER(label) = LOWER(:label)", nativeQuery = true)
    CategoryModel findCategoryByLabel(@Param("label") String label);
}
