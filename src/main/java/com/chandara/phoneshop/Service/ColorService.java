package com.chandara.phoneshop.Service;
import com.chandara.phoneshop.entity.Color;

public interface ColorService {
	Color create(Color color);
	Color getById(Long id);
}
