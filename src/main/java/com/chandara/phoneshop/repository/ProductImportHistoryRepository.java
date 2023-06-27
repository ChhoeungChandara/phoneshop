package com.chandara.phoneshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chandara.phoneshop.entity.ProductImportHistories;
public interface ProductImportHistoryRepository extends JpaRepository<ProductImportHistories,Long>{
	
}
