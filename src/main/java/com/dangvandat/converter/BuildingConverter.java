package com.dangvandat.converter;

import com.dangvandat.dto.BuildingDTO;
import com.dangvandat.entity.BuildingEntity;
import com.dangvandat.entity.RentArea;
import com.dangvandat.repository.RentAreaRepository;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	public BuildingDTO convertToDTO(BuildingEntity buildingEntity) {
		BuildingDTO result = modelMapper.map(buildingEntity, BuildingDTO.class);
        /*List<RentArea> rentAreas = repository.findAll(condition,new PageRequest(null,null,null));
        List<String> rents = new ArrayList<>();
        for(RentArea rens : rentAreas){
            rents.add(rens.getValue());
        }
        if(rents.size() > 0){
            result.setRentArea(StringUtils.join(rents,","));
        }*/
        List<String> rents = rentAreaRepository.findRentAreaByBuildingId(buildingEntity.getId()).stream().map(RentArea::getValue).collect(Collectors.toList());
        if(rents.size() > 0){
            result.setRentArea(StringUtils.join(rents,","));
        }
		return result;
	}
	
	public BuildingEntity convertToEntity(BuildingDTO buildingDTO) {
		BuildingEntity result = modelMapper.map(buildingDTO, BuildingEntity.class);
		if(StringUtils.isNotBlank(buildingDTO.getNumberOfBasement())){
            result.setNumberOfBasement(Integer.parseInt(buildingDTO.getNumberOfBasement()));
        }
        if(StringUtils.isNotBlank(buildingDTO.getBuildingArea())){
            result.setBuildingArea(Integer.parseInt(buildingDTO.getBuildingArea()));
        }
		return result;
	}
	
}
