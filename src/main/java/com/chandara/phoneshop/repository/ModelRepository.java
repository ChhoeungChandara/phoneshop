package com.chandara.phoneshop.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chandara.phoneshop.entity.Model;


public interface ModelRepository extends JpaRepository<Model, Long> {
	List<Model> findByBrandId(Long brandId);
	}
