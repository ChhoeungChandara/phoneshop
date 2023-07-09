package com.chandara.phoneshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.chandara.phoneshop.entity.Sale;
public interface SaleRepository extends JpaRepository<Sale,Long>{
	
}
