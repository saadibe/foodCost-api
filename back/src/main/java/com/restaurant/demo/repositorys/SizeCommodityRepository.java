package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.SizeCommodityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SizeCommodityRepository extends JpaRepository<SizeCommodityModel, Long> {

    @Query( value = "select * from size_commodity where label = :label", nativeQuery = true)
    SizeCommodityModel findSizeByLabel(@Param("label") String label);
}
