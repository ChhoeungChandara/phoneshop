package com.chandara.phoneshop.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chandara.phoneshop.Entity.Brand;

public interface BrandRepository extends JpaRepository<Brand,Long>{
	Brand findByName(String name);

}
