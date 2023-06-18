package com.chandara.phoneshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chandara.phoneshop.entity.Color;

public interface ColorRepository extends JpaRepository<Color,Long>{
	
}
