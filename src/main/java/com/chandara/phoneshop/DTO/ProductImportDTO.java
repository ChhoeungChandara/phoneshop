package com.chandara.phoneshop.DTO;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ProductImportDTO {
	
	@NotNull(message = "product id must not be null")
	private Long productId;
	@Min(value = 1,message = "product unit can not 0")
	private Integer productUnit;
	@DecimalMin(value = "0.0000001",message = "price must be grater than 0")
	private BigDecimal importPrice;
	@NotNull(message = "date can not be null")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate importDate;
}
