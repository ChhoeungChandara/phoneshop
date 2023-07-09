package com.chandara.phoneshop.DTO;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SaleDTO {
	private List<ProductSaleDTO> products;
	private LocalDate saleDate;

}
