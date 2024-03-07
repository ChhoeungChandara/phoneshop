package com.chandara.phoneshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.chandara.phoneshop.Entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long> , JpaSpecificationExecutor<Brand>{
	Brand findByName(String name);

}
