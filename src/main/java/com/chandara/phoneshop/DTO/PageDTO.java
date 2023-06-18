package com.chandara.phoneshop.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDTO {
	List<?> list;
	private PaginationDTO paginationDTO;
	@SuppressWarnings("static-access")
	public  PageDTO(Page<?> page) {
		this.list = page.getContent();
		this.paginationDTO = paginationDTO.builder()
				             .empty(page.isEmpty())
				             .first(page.isFirst())
				             .last(page.isLast())
				             .PageSize(page.getPageable().getPageSize())
				             .PageNumber(page.getPageable().getPageNumber())
				             .totalPage(page.getTotalPages())
				             .totalElement(page.getTotalElements())
				             .numberofElement(page.getNumberOfElements())
				             .build();
				             
		
	}
}
