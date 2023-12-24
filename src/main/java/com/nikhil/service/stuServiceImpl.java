package com.nikhil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nikhil.Dto.StudentDto;
import com.nikhil.Entity.Student;
import com.nikhil.Helper.PageableResponse;
import com.nikhil.Repo.stuRepo;

@Service
public class stuServiceImpl implements stuServiceI {
	
	@Autowired
	private stuRepo stuRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public StudentDto create(StudentDto studentDto) {
		Student student = this.mapper.map(studentDto, Student.class);
		Student student2 = this.stuRepo.save(student);
		StudentDto studentDto2 = this.mapper.map(student2, StudentDto.class);
		return studentDto2;
	}

	@Override
	public PageableResponse<StudentDto> allEmp(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
	        Sort sort = null;
	        if(sortDir.equalsIgnoreCase("asc")) {
	        	sort = Sort.by(sortBy).ascending();
	        }else {
	        	sort=Sort.by(sortBy).descending();
	        	
	        }
	        
	        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,sort);
	        Page<Student> findAll = this.stuRepo.findAll(pageRequest);
	        List<Student> stu = findAll.getContent();
	        List<StudentDto> stuDto = stu.stream().map(student->this.mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	       
	        PageableResponse<StudentDto> pageableResponse = new PageableResponse<>();
	        pageableResponse.setContent(stuDto);
	        pageableResponse.setPageNumber(pageNumber);
	        pageableResponse.setPageSize(pageSize);
	        pageableResponse.setTotalElement(findAll.getTotalElements());
	        pageableResponse.setIsLast(findAll.isLast());
	        
		return pageableResponse;
	}

}
