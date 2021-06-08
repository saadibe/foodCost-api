package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.SizeCommodityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeCommodityRepository extends JpaRepository<SizeCommodityModel, Long> {
}
