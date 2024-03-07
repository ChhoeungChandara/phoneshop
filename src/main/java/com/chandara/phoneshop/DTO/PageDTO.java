package com.chandara.phoneshop.DTO;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;
@Data
public class PageDTO {

	List<?> list;
	private PaginationDTO pagination;
	public PageDTO(Page<?> page) {
		this.list = page.getContent();
		this.pagination = PaginationDTO.builder()
				.empty(page.isEmpty())
				.first(page.isFirst())
				.last(page.isLast())
				.PageSize(page.getPageable().getPageSize())
				.PageNumber(page.getPageable().getPageNumber()+1)
				.totalPage(page.getTotalPages())
				.totalElement(page.getTotalElements())
				.numberofElement(page.getNumberOfElements())
				.build();
	}

}
