package com.nikhil.service;

import org.springframework.stereotype.Service;


import com.nikhil.Dto.StudentDto;
import com.nikhil.Helper.PageableResponse;

@Service
public interface stuServiceI {

	StudentDto create(StudentDto studentDto);

	PageableResponse<StudentDto> allEmp(Integer pageNumber,Integer pageSize, String sortBy, String sortDir);
	
	
}
