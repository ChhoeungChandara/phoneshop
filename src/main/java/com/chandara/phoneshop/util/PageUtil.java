package com.chandara.phoneshop.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {
	int DEFAULT_PAGE_LIMIT = 2;
	int DEFAULT_PAGE_NUMBER = 1;
	String PAGE_LIMIT = "_limit";
	String PAGE_NUMBER= "_Number";
	static Pageable getPageable(int PageNumber, int PageSize) {
	
		if(PageNumber<DEFAULT_PAGE_NUMBER) {
			PageNumber = DEFAULT_PAGE_NUMBER;
		}
		if(PageSize<1) {
			PageSize = DEFAULT_PAGE_LIMIT;
		}
		Pageable pageable = PageRequest.of(PageNumber-1, PageSize);
		return pageable;
	}
}
 