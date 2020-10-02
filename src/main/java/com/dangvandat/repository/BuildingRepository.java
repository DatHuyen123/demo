package com.dangvandat.repository;

import com.dangvandat.entity.BuildingEntity;
import com.dangvandat.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BuildingRepository extends JpaRepository<BuildingEntity , Long> , BuildingRepositoryCustom{

}
