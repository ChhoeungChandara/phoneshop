package com.chandara.phoneshop.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Model;
import com.chandara.phoneshop.exception.ResourceNotFoundException;
import com.chandara.phoneshop.repository.ModelRepository;

@Service
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelRepository modelRepository;
	@Override
	public Model save(Model model) {
	     return modelRepository.save(model);
	}
	@Override
	public List<Model> getByBrand(long brandId) {
		return modelRepository.findByBrandId(brandId);
	}
	@Override
	public Model getById(Long id) {
		return modelRepository.findById(id)
				              .orElseThrow(()-> new ResourceNotFoundException("model", id));
	}
}
