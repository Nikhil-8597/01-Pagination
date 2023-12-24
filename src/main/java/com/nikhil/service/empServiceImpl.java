package com.nikhil.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nikhil.Dto.EmployeeDto;
import com.nikhil.Entity.Employee;
import com.nikhil.Helper.PageableResponse;
import com.nikhil.Repo.EmpREpo;

@Service
public class empServiceImpl implements empServiceI {
	
	
	@Autowired
	private EmpREpo empREpo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto create(EmployeeDto employeeDto) {
		Employee employee = this.mapper.map(employeeDto, Employee.class);
		Employee employee2 = this.empREpo.save(employee);
		EmployeeDto employeeDto2 = this.mapper.map(employee2, EmployeeDto.class);
		return employeeDto2;
	}

	@Override
	public PageableResponse<EmployeeDto> allEmp(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		Sort sort=(sortDir.equalsIgnoreCase("Asc"))
				?(Sort.by(sortBy).ascending())
		        :(Sort.by(sortBy).ascending());
		
         PageRequest request = PageRequest.of(pageNumber, pageSize, sort);
         
        Page<Employee> page = this.empREpo.findAll(request);
         List<Employee> content = page.getContent();
        List<EmployeeDto> empDtoList = content.stream().map(con-> this.mapper.map(con, EmployeeDto.class)).collect(Collectors.toList());
      PageableResponse<EmployeeDto> pageable = new PageableResponse<EmployeeDto>();
      pageable.setContent(empDtoList);
      pageable.setPageNumber(pageNumber);
      pageable.setPageSize(pageSize);
      pageable.setTotalElement(page.getTotalElements());
      pageable.setIsLast(page.isLast());		
		return pageable;
	}

}
