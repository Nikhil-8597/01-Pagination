package com.nikhil.service;

import org.springframework.stereotype.Service;

import com.nikhil.Dto.EmployeeDto;
import com.nikhil.Helper.PageableResponse;
@Service
public interface empServiceI {
	
	EmployeeDto create(EmployeeDto employeeDto);

	PageableResponse<EmployeeDto> allEmp(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	
}
