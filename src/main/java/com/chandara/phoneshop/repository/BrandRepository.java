package com.chandara.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chandara.phoneshop.entity.Brand;
public interface BrandRepository extends JpaRepository<Brand,Long> ,JpaSpecificationExecutor<Brand>{
	
	List<Brand>findByName(String name);
}
