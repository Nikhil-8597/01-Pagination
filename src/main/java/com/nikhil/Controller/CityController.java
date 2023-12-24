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

import com.nikhil.Dto.CityDto;
import com.nikhil.Dto.StudentDto;
import com.nikhil.Helper.PageableResponse;
import com.nikhil.service.cityServiceI;
import com.nikhil.service.stuServiceI;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private cityServiceI empServiceI;
	
	@PostMapping("/")
	public ResponseEntity<CityDto> create(@RequestBody CityDto employeeDto){
		CityDto employeeDto2 = this.empServiceI.create(employeeDto);
		return new ResponseEntity<CityDto>(employeeDto2,HttpStatus.CREATED);
	}
    @GetMapping("/")
	public ResponseEntity< PageableResponse<CityDto>>allEmp(
		@RequestParam(value = "pageNumber" ,defaultValue = "0",required = false) Integer pageNumber,
		@RequestParam(value = "pageSize" ,defaultValue = "5",required = false) Integer pageSize, 
		@RequestParam(value = "sortBy" ,defaultValue = "population",required = false) String sortBy,
		@RequestParam(value = "sortDir" ,defaultValue = "ASCj",required = false) String sortDir){
		PageableResponse<CityDto> allEmp = this.empServiceI.allEmp(pageNumber, pageSize, sortBy, sortDir);
		
		return new ResponseEntity<PageableResponse<CityDto>>(allEmp,HttpStatus.OK);
		
		
	}


}
