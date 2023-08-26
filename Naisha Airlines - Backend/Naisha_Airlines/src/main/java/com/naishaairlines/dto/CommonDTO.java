package com.naishaairlines.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonDTO<T> {
	private List<T> list;
	private int pageSize;
	private int pageNumber;
	private Long totalElements;
	private int totalPages;
	private boolean isLastPage;
}
