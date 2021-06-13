package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.ElementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ElementRepository extends JpaRepository<ElementModel, Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from element_recipe where element = :element_id", nativeQuery = true)
    void clearRecipeList(@Param("element_id") Long element_id);
}
