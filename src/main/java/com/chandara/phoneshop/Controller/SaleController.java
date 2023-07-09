package com.chandara.phoneshop.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chandara.phoneshop.DTO.SaleDTO;
import com.chandara.phoneshop.Service.SaleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("sales")
public class SaleController {

	private final  SaleService saleService;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody  SaleDTO saleDTO){
		saleService.sell(saleDTO);;
		return ResponseEntity.ok("success");
	}
	

}
