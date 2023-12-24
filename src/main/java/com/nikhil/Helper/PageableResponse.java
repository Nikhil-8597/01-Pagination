package com.nikhil.Helper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageableResponse<V> {
	
	private List<V> content; 
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElement;
	private Boolean isLast;
	
	

}
