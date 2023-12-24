package com.nikhil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.Dto.EmployeeDto;
import com.nikhil.Dto.StudentDto;
import com.nikhil.Helper.PageableResponse;
import com.nikhil.service.empServiceI;
import com.nikhil.service.stuServiceI;
@RestController
@RequestMapping("/stu")
public class StuController {
	
	@Autowired
	private stuServiceI empServiceI;
	
	@PostMapping("/")
	public ResponseEntity<StudentDto> create(@RequestBody StudentDto employeeDto){
		StudentDto employeeDto2 = this.empServiceI.create(employeeDto);
		return new ResponseEntity<StudentDto>(employeeDto2,HttpStatus.CREATED);
	}
    @GetMapping("/")
	public ResponseEntity< PageableResponse<StudentDto>>allEmp(
		@RequestParam(value = "pageNumber" ,defaultValue = "0",required = false) Integer pageNumber,
		@RequestParam(value = "pageSize" ,defaultValue = "2",required = false) Integer pageSize, 
		@RequestParam(value = "sortBy" ,defaultValue = "marks",required = false) String sortBy,
		@RequestParam(value = "sortDir" ,defaultValue = "ASCj",required = false) String sortDir){
		PageableResponse<StudentDto> allEmp = this.empServiceI.allEmp(pageNumber, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PageableResponse<StudentDto>>(allEmp,HttpStatus.OK);
		
		
	}

}
