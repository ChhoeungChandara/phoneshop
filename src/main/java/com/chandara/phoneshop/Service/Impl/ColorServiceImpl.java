package com.chandara.phoneshop.Service.Impl;

import org.springframework.stereotype.Service;

import com.chandara.phoneshop.Service.ColorService;
import com.chandara.phoneshop.entity.Color;
import com.chandara.phoneshop.exception.ResourceNotFoundException;
import com.chandara.phoneshop.repository.ColorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {

	private final ColorRepository colorRepository;
	@Override
	public Color create(Color color) {
		return colorRepository.save(color);
	}

	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id)
				              .orElseThrow(()->new ResourceNotFoundException("color", id));
	}

}
