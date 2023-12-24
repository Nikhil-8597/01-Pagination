package com.nikhil.Helper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;



public class Helper {
	
	
	
	public static <U,V> PageableResponse<V> getResponse(Page<U> page, Class<V> type){
		

	    List<U> content = page.getContent();
		List<V> collect = content.stream().map(object->new ModelMapper().map(object, type)).collect(Collectors.toList());
		 
		PageableResponse<V> pResponse = new PageableResponse<>();
		pResponse.setContent(collect);
		pResponse.setPageNumber(page.getNumber());
		pResponse.setPageSize(page.getSize());
		pResponse.setIsLast(page.isLast());
		pResponse.setTotalElement(page.getTotalElements());
		return pResponse;
	}

}
