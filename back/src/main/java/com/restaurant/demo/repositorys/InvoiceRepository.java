package com.restaurant.demo.repositorys;

import com.restaurant.demo.models.InvoiceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceModel, Long> {
}
