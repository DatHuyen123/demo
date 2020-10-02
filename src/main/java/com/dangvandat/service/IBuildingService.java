package com.dangvandat.service;

import com.dangvandat.builder.BuildingSearchBuilder;
import com.dangvandat.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IBuildingService {
    BuildingDTO save(BuildingDTO newBuildingDTO);
    BuildingDTO update(BuildingDTO updateBuildingDTO , Long id);
    void delete(Long[] ids);
    List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder, Pageable pageble);
    Long getTotalItems(BuildingSearchBuilder builder);
    BuildingDTO finById(Long id);
    Map<String , String> getDistrict();
    Map<String , String> getBuildingType();
}
