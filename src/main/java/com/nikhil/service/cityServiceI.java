package com.nikhil.service;

import org.springframework.stereotype.Service;

import com.nikhil.Dto.CityDto;

import com.nikhil.Helper.PageableResponse;
@Service
public interface cityServiceI {
	
	CityDto create(CityDto CityDto);

	PageableResponse<CityDto> allEmp(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	

}
