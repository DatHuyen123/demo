package com.dangvandat.service.impl;

import com.dangvandat.builder.BuildingSearchBuilder;
import com.dangvandat.config.TokenProvider;
import com.dangvandat.contant.SystemContant;
import com.dangvandat.converter.BuildingConverter;
import com.dangvandat.dto.AuthToken;
import com.dangvandat.dto.BuildingDTO;
import com.dangvandat.entity.BuildingEntity;
import com.dangvandat.entity.RentArea;
import com.dangvandat.enums.BuildingType;
import com.dangvandat.enums.District;
import com.dangvandat.repository.BuildingRepository;
import com.dangvandat.repository.RentAreaRepository;
import com.dangvandat.service.IBuildingService;
import com.dangvandat.util.JwtTokenUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO newBuildingDTO) {
        // save building to database
        newBuildingDTO.setCreatedBy(jwtTokenUtils.getUserName());
        newBuildingDTO.setModifiedBy(jwtTokenUtils.getUserName());
        BuildingEntity newBuildingEntity = buildingConverter.convertToEntity(newBuildingDTO);
        newBuildingEntity.setType(StringUtils.join(newBuildingDTO.getBuildingTypes(), ","));
        newBuildingEntity = buildingRepository.save(newBuildingEntity);
        //save rentarea by buildingid
        if (StringUtils.isNotBlank(newBuildingDTO.getRentArea())) {
            insertRentArea(newBuildingDTO.getRentArea().split(","), newBuildingEntity);
        }
        return this.finById(newBuildingEntity.getId());
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuildingDTO, Long id) {
        BuildingEntity oldBuilding = buildingRepository.findById(id).get();
        if (oldBuilding != null) {
            rentAreaRepository.deleteRentAreaByBuildingId(oldBuilding.getId());
            oldBuilding = buildingConverter.convertToEntity(updateBuildingDTO);
            if (StringUtils.isNotBlank(updateBuildingDTO.getRentArea())) {
                insertRentArea(updateBuildingDTO.getRentArea().split(","), oldBuilding);
            }
            buildingRepository.save(oldBuilding);
        }
        return buildingConverter.convertToDTO(buildingRepository.findById(oldBuilding.getId()).get());
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (long item : ids) {
            rentAreaRepository.deleteRentAreaByBuildingId(item);
            buildingRepository.deleteById(item);
        }
    }

    @Override
    public List<BuildingDTO> findAll(BuildingSearchBuilder buildingSearchBuilder, Pageable pageble) {
        Map<String, Object> properties = builMapSearch(buildingSearchBuilder);
        //List<BuildingEntity> buildingEntities = buildingRepository.;
        //return findAll(properties , pageble , buildingSearchBuilder);
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, pageble, buildingSearchBuilder);
        return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
    }

    @Override
    public Long getTotalItems(BuildingSearchBuilder builder) {
        Map<String, Object> mapSearch = builMapSearch(builder);
        Long count = buildingRepository.getToltalItems(mapSearch, builder);
        return count;
    }

    @Override
    public BuildingDTO finById(Long id) {
        final BuildingDTO[] response = {null};
        buildingRepository.findById(id).ifPresent(buildingEntity -> {
            response[0] = buildingConverter.convertToDTO(buildingEntity);
        });
        return response[0];
    }

    @Override
    public Map<String, String> getDistrict() {
        Map<String, String> result = new HashMap<>();
        Stream.of(District.values()).forEach(item -> {
            result.put(item.name(), item.getValue());
        });
        return result;
    }

    @Override
    public Map<String, String> getBuildingType() {
        Map<String, String> result = new HashMap<>();
        Stream.of(BuildingType.values()).forEach(item -> {
            result.put(item.name(), item.getValue());
        });
        return result;
    }

    private void insertRentArea(String[] rentArea, BuildingEntity newBuildingEntity) {
        BuildingEntity buildingEntity = newBuildingEntity;
        if (rentArea.length > 0) {
            for (String item : rentArea) {
                RentArea rents = new RentArea();
                rents.setValue(item);
                rents.setBuilding(buildingEntity);
                rents.setCreatedBy(jwtTokenUtils.getUserName());
                rents.setModifiedBy(jwtTokenUtils.getUserName());
                rentAreaRepository.save(rents);
            }
        }
    }

    private Map<String, Object> builMapSearch(BuildingSearchBuilder builder) {
        Map<String, Object> result = new HashMap<>();
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                if (!field.getName().equals("buildingTypes")
                        && !field.getName().startsWith("costRent")
                        && !field.getName().startsWith("areaRent")) {
                    field.setAccessible(true);
                    if (field.get(builder) != null) {
                        if (field.getName().equals("numberOfBasement") || field.getName().equals("buildingArea")) {
                            if (StringUtils.isNotEmpty((String) field.get(builder))) {
                                result.put(field.getName().toLowerCase(), Integer.parseInt((String) field.get(builder)));
                            }
                        } else {
                            if (!field.get(builder).equals("")) {
                                result.put(field.getName().toLowerCase(), field.get(builder));
                            }
                        }
                    }
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

}
