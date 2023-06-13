package com.chandara.phoneshop.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandara.phoneshop.DTO.ModelDTO;
import com.chandara.phoneshop.Service.ModelService;
import com.chandara.phoneshop.entity.Model;
import com.chandara.phoneshop.mapper.ModelMapper;

@RestController
@RequestMapping("/models")
public class ModelController {
	@Autowired
	private ModelService modelService;
	@Autowired
	private ModelMapper  modelMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO){
		Model model = modelMapper.toModel(modelDTO);
	    model = modelService.save(model);
		return ResponseEntity.ok(model);
	}

}
