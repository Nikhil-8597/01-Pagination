package com.nikhil.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nikhil.Dto.CityDto;
import com.nikhil.Entity.City;
import com.nikhil.Helper.Helper;
import com.nikhil.Helper.PageableResponse;
import com.nikhil.Repo.cityRepo;

@Service
public class cityServiceImpl implements cityServiceI{
	
	

	@Autowired
	private cityRepo cityRepo;
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public CityDto create(CityDto CityDto) {
     City city = this.mapper.map(CityDto, City.class);
     City city2 = this.cityRepo.save(city);
    CityDto cityDto2 = this.mapper.map(city2, CityDto.class);
		return cityDto2;
	}

	@Override
	public PageableResponse<CityDto> allEmp(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
	Sort sort = null;
	if(sortDir.equalsIgnoreCase("asc")) {
		sort=Sort.by(sortBy).ascending();
	}else {
		sort=Sort.by(sortBy).descending();
	}
	

	
	PageRequest pageRequest = PageRequest.of(pageNumber, pageSize,sort);
	Page<City> findAll = this.cityRepo.findAll(pageRequest);
//	List<City> content = findAll.getContent();
//	List<CityDto> collect = content.stream().map(city->this.mapper.map(city, CityDto.class)).collect(Collectors.toList());
//	
//	PageableResponse<CityDto> pResponse = new PageableResponse<>();
//	pResponse.setContent(collect);
//	pResponse.setPageNumber(pageNumber);
//	pResponse.setPageSize(pageSize);
//	pResponse.setIsLast(findAll.isLast());
//	pResponse.setTotalElement(findAll.getTotalElements());
	
	PageableResponse<CityDto> response = Helper.getResponse(findAll, CityDto.class);
	return response;
	
	
	
	
	
	}

}
