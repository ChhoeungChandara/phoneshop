package com.chandara.phoneshop.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {

	private int PageSize;
	private int PageNumber;
	private int totalPage;
	private Long totalElement;
	private long numberofElement;
	private boolean first;
	private boolean last;
	private boolean empty;
}
