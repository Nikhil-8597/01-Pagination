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
import com.nikhil.Helper.PageableResponse;
import com.nikhil.service.empServiceI;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private empServiceI empServiceI;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto){
		EmployeeDto employeeDto2 = this.empServiceI.create(employeeDto);
		return new ResponseEntity<EmployeeDto>(employeeDto2,HttpStatus.CREATED);
	}
    @GetMapping("/")
	public ResponseEntity< PageableResponse<EmployeeDto>>allEmp(
		@RequestParam Integer pageNumber,
		@RequestParam Integer pageSize, 
		@RequestParam String sortBy,
		@RequestParam String sortDir){
		PageableResponse<EmployeeDto> allEmp = this.empServiceI.allEmp(pageNumber, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PageableResponse<EmployeeDto>>(allEmp,HttpStatus.OK);
		
		
	}
}
