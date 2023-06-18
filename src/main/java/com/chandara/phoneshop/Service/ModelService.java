package com.chandara.phoneshop.Service;
import java.util.List;

import com.chandara.phoneshop.entity.Model;

public interface ModelService {
	Model save(Model model);
	List<Model> getByBrand(long brandId);
	Model getById(Long id);
}
