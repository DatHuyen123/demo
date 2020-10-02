package com.dangvandat.repository.custom;

import com.dangvandat.builder.BuildingSearchBuilder;
import com.dangvandat.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable, BuildingSearchBuilder builder);
    Long getToltalItems(Map<String , Object> mapSearch , BuildingSearchBuilder builder);
}
